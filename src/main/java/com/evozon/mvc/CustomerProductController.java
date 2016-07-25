package com.evozon.mvc;


import com.evozon.dao.CartDAO;
import com.evozon.domain.Address;
import com.evozon.domain.AddressDTO;
import com.evozon.domain.Cart;
import com.evozon.domain.Product;
import com.evozon.service.CartService;
import com.evozon.service.CategoryService;
import com.evozon.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping(value = "products")
public class CustomerProductController {

    public static final int MAX_PRODUCTS_PER_PAGE= 12;

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CartService cartService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllProducts(@RequestParam(value = "sortValue", defaultValue = "none") String sortValue,
                                 Model model, @RequestParam(value = "page", defaultValue = "1") Integer startPageIndex) {
        model.addAttribute("products", productService.getSortedProducts(sortValue,startPageIndex, MAX_PRODUCTS_PER_PAGE));
        model.addAttribute("productSize", productService.getSize());
        model.addAttribute("currentPage",startPageIndex);
        model.addAttribute("sortValue",sortValue);
        model.addAttribute("categories",categoryService.getCategoriesWithAtLeastOneProduct());
        return "customerViewProducts";
    }

    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public String getSortedProducts(@RequestParam(value = "sortValue") String sortValue, Model model,
                                    @RequestParam(value = "page", defaultValue = "1") Integer startPageIndex,
                                    @RequestParam(value="category", defaultValue = "none") Integer categoriesIds) {

        model.addAttribute("products", productService.getSortedProducts(sortValue,startPageIndex, MAX_PRODUCTS_PER_PAGE));
        model.addAttribute("productSize", productService.getSize());
        model.addAttribute("currentPage",startPageIndex);

        return "customerViewProducts";
    }

/*    @RequestMapping(value = "/address", method = RequestMethod.GET)
    public String gotToCheckoutPage(Model model, HttpServletRequest request) {
        Cart shoppingCart;
        HttpSession session = request.getSession();
        shoppingCart = (Cart) session.getAttribute("cart");
        if (shoppingCart == null) {
            shoppingCart = new Cart();
            session.setAttribute("cart", shoppingCart);
        }
        model.addAttribute("cart", shoppingCart);
        return "customerCartCheckout";
    }

    @RequestMapping(value = "/address", method = RequestMethod.POST)
    public String checkoutAddress(HttpServletRequest request, Model model, @ModelAttribute("address") AddressDTO address, BindingResult data, @ModelAttribute("cart") Cart cart) {
        try {

            model.addAttribute("address", address);
            Address deliveryAddress = new Address();
            Address billingAddress = new Address();
            deliveryAddress.setCity(address.getDeliveryCity());
            deliveryAddress.setNumber(address.getDeliveryNumber());
            deliveryAddress.setStreetName(address.getDeliveryStreet());
            deliveryAddress.setPhone(address.getDeliveryPhone());
            billingAddress.setCity(address.getBillingCity());
            billingAddress.setNumber(address.getBillingNumber());
            billingAddress.setPhone(address.getBillingPhone());
            billingAddress.setStreetName(address.getBillingStreet());
            cart.setDeliveryAddress(deliveryAddress);
            cart.setBillingAddress(billingAddress);

            model.addAttribute("data", true);
            HttpSession session = request.getSession();
            session.setAttribute("cart", cart);
            if (!data.hasErrors()) {
                cartService.updateAddress(cart);
            }
            if (data.hasErrors()) {
                model.addAttribute("data", false);
                return "customerCartCheckout";
            }
        } catch (Exception e) {
            model.addAttribute("data", false);
        }
        return "customerCartCheckout";
    }*/

    @RequestMapping(value = "/checkout/{cartId}", method = RequestMethod.GET)
    public String goToCheckout(@PathVariable("cartId") int cartId, Model model) {
        Cart cart = cartService.getCartById(cartId);
        model.addAttribute("cart", cart);
        System.out.println("THE ID" + cart.getCartId());
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setDeliveryCity(cart.getDeliveryAddress().getCity());
        addressDTO.setDeliveryNumber(cart.getDeliveryAddress().getNumber());
        addressDTO.setDeliveryStreet(cart.getDeliveryAddress().getStreetName());
        addressDTO.setDeliveryPhone(cart.getDeliveryAddress().getPhone());
        addressDTO.setBillingCity(cart.getBillingAddress().getCity());
        addressDTO.setBillingNumber(cart.getBillingAddress().getNumber());
        addressDTO.setBillingStreet(cart.getBillingAddress().getStreetName());
        addressDTO.setBillingPhone(cart.getBillingAddress().getPhone());
        addressDTO.setCartId(cartId);
        model.addAttribute("address", addressDTO);
        System.out.println("This is the street" + addressDTO.getDeliveryStreet());
        return "customerCartCheckout";
    }

    @RequestMapping(value = "checkout", method = RequestMethod.POST)
    public String checkout(Model model, @ModelAttribute("address") AddressDTO address, BindingResult data) {
        model.addAttribute("address", address);
        if(data.hasErrors()){
            return "customerCartCheckout";
        }
        Cart cart = cartService.getCartById(address.getCartId());
        Address deliveryAddress = new Address();
        Address billingAddress = new Address();
        deliveryAddress.setCity(address.getDeliveryCity());
        deliveryAddress.setNumber(address.getDeliveryNumber());
        deliveryAddress.setStreetName(address.getDeliveryStreet());
        deliveryAddress.setPhone(address.getDeliveryPhone());
        billingAddress.setCity(address.getBillingCity());
        billingAddress.setNumber(address.getBillingNumber());
        billingAddress.setPhone(address.getBillingPhone());
        billingAddress.setStreetName(address.getBillingStreet());
        cart.setDeliveryAddress(deliveryAddress);
        cart.setBillingAddress(billingAddress);
        cartService.updateAddress(cart);
        model.addAttribute("cart", cart);
        System.out.println("This is the cart id " + cart.getCartId());
        return "customerOrderPlaced";
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String showProductDetails(Model model, @RequestParam String productId){
        model.addAttribute("theProduct", productService.getProductById(Integer.parseInt(productId)));
        return "productDetailsPage";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String deleteAll(@RequestParam(value = "sortValue", defaultValue = "none") String sortValue,
                            Model model, @RequestParam(value = "page", defaultValue = "1") Integer startPageIndex,
                            @RequestParam(value = "selectedCategoriesArray[]") List<Integer> categoriesArray) {


        return "customerViewProducts";
    }
}