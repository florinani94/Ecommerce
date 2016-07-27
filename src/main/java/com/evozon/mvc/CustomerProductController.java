package com.evozon.mvc;


import com.evozon.dao.CartDAO;
import com.evozon.domain.*;
import com.evozon.domain.dtos.OrdersDTO;
import com.evozon.domain.*;
import com.evozon.service.*;
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
import java.util.UUID;


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

    @Autowired
    private OrderService orderService;

    @Autowired
    private SendOrderMail orderManager;

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


    @RequestMapping(value = "/checkout/{cartId}", method = RequestMethod.GET)
    public String goToCheckout(@PathVariable("cartId") int cartId, Model model) {
        Cart cart = new Cart();
        if (cartService.getCartById(cartId) != null) {
            cart = cartService.getCartById(cartId);
        }
        model.addAttribute("cart", cart);
        OrdersDTO ordersDTO = new OrdersDTO();
        ordersDTO.getDataFromCart(cart);
        model.addAttribute("order", ordersDTO);
        return "customerCartCheckout";
    }


    @RequestMapping(value = "checkout", method = RequestMethod.POST)
    public String checkout(Model model, @ModelAttribute("order") OrdersDTO order, BindingResult data) {
        model.addAttribute("order", order);
        if(data.hasErrors()){
            return "customerCartCheckout";
        }
        Cart cart = cartService.getCartById(order.getCartId());
        Address deliveryAddress = new Address();
        Address billingAddress = new Address();
        Payment payment = new Payment();
        deliveryAddress.setCity(order.getDeliveryCity());
        deliveryAddress.setNumber(order.getDeliveryNumber());
        deliveryAddress.setStreet(order.getDeliveryStreet());
        deliveryAddress.setPhone(order.getDeliveryPhone());
        billingAddress.setCity(order.getBillingCity());
        billingAddress.setNumber(order.getBillingNumber());
        billingAddress.setPhone(order.getBillingPhone());
        billingAddress.setStreet(order.getBillingStreet());
        payment.setPaymentMethod(order.getPaymentMethod());
        payment.setCardNumber(order.getCardNumber());
        payment.setCardCode(order.getCardCode());
        cart.setDeliveryAddress(deliveryAddress);
        cart.setBillingAddress(billingAddress);
        cart.setPayment(payment);
        cart.setEmail(order.getEmail());
        cartService.updateAddress(cart);
        model.addAttribute("cart", cart);
        String keyUrl = UUID.randomUUID().toString();
        orderManager.sendOrderPlacementMail("iuliacodau@yahoo.com", "iulia", keyUrl, "order");
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

    /* Order details page */

    @RequestMapping(value = "details", method = RequestMethod.GET)
    public String getOrderDetailsPage(@RequestParam("orderKey") String orderKey, Model model) {
        Orders orderDetails = orderService.getOrderByKey(orderKey);
        List<Entry> entries = orderService.getAllEntries(orderDetails.getOrdersId());
        model.addAttribute("orderDetails", orderDetails);
        model.addAttribute("entries", entries);

        return "orderDetails";
    }
}