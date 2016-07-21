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

    @RequestMapping(value = "/address", method = RequestMethod.GET)
    public String gotToCheckoutPage(Model model) {
        model.addAttribute("cart", new Product());
        return "customerCartCheckout";
    }

    @RequestMapping(value = "/address", method = RequestMethod.POST)
    public String checkoutAddress(Model model, @ModelAttribute("address") AddressDTO address, BindingResult data) {
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
            Cart cart = new Cart();
            cart.setDeliveryAddress(deliveryAddress);
            cart.setBillingAddress(billingAddress);
            cartService.addCart(cart);
            model.addAttribute("data", true);
            if (data.hasErrors()) {
                model.addAttribute("data", false);
                return "customerCartCheckout";
            }
        } catch (Exception e) {
            model.addAttribute("data", false);
        }
        return "customerCartCheckout";
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String showProductDetails(Model model, @RequestParam String productId){
        model.addAttribute("theProduct", productService.getProductById(Integer.parseInt(productId)));
        return "productDetailsPage";
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String getProductByCategories(@RequestParam(value = "sortValue") String sortValue, Model model,
                                    @RequestParam(value = "page", defaultValue = "1") Integer startPageIndex,
                                    @RequestParam(value="category") List<Integer> categoriesIds) {


        model.addAttribute("products", productService.getSortedProducts(sortValue,startPageIndex, MAX_PRODUCTS_PER_PAGE));
        model.addAttribute("productSize", productService.getSize());
        model.addAttribute("currentPage",startPageIndex);




        return "customerViewProducts";
    }
}