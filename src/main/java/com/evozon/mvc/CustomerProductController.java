package com.evozon.mvc;


import com.evozon.dao.CartDAO;
import com.evozon.domain.*;
import com.evozon.domain.dtos.OrdersDTO;
import com.evozon.domain.*;
import com.evozon.mvc.validator.OrderValidator;
import com.evozon.service.*;
import com.evozon.util.CreateUrlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
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

    @Autowired
    private CreateUrlUtils createUrlUtils;

    @Autowired
    private OrderValidator validator;

    @RequestMapping(method = RequestMethod.GET)
    public String getProducts(@RequestParam(value = "sortValue", defaultValue = "none") String sortValue,
                                 Model model, @RequestParam(value = "page", defaultValue = "1") Integer startPageIndex,
                                 @RequestParam(value = "category", defaultValue = "") Integer[] categoriesArray) {


        List<Integer> categoriesList;
        if(categoriesArray.length != 0) {
            categoriesList = new ArrayList<>(Arrays.asList(categoriesArray));
            for (Integer categoryValue : categoriesArray) {
            }
        }
        else {
            categoriesList = new ArrayList<>();
        }
        model.addAttribute("products", productService.getSortedProducts(sortValue,startPageIndex, MAX_PRODUCTS_PER_PAGE,categoriesList));
        model.addAttribute("productSize", productService.getSize(categoriesList));
        model.addAttribute("currentPage", startPageIndex);
        model.addAttribute("sortValue", sortValue);
        model.addAttribute("categories", categoryService.getCategoriesWithAtLeastOneProduct());
        model.addAttribute("selectedCategoriesUrl", createUrlUtils.CreateUrlForFilter(categoriesArray));
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
        validator.validate(order, data);
        if(data.hasErrors()){
            return "customerCartCheckout";
        }
        Cart cart = cartService.getCartById(order.getCartId());
        cartService.getDataFromOrderds(order, cart);
        cartService.updateAddress(cart);
        model.addAttribute("cart", cart);
        return "customerOrderPlaced";
    }

    @RequestMapping(value = "/customerOrderPlaced", method = RequestMethod.GET)
    public String orderPlaced(@RequestParam(value = "cartId") Integer cartId) {
        Cart cart = cartService.getCartById(cartId);
        String keyUrl = UUID.randomUUID().toString();
        Orders orderPlaced = new Orders();
        orderPlaced.cloneCart(cart);
        orderPlaced.setOrdersKey(keyUrl);
        orderPlaced.setStatus("processing");
        orderService.addOrder(orderPlaced);
        orderManager.sendOrderPlacementMail(orderPlaced.getEmail(), "iulia", keyUrl, "/mvc/products/details");
        return "customerOrderPlaced";
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String showProductDetails(Model model, @RequestParam String productId){
        model.addAttribute("theProduct", productService.getProductById(Integer.parseInt(productId)));
        model.addAttribute("successMessage","test");
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
        Cart orderDetails = orderService.getOrderByKey(orderKey);
        List<Entry> entries = orderService.getAllEntries(orderDetails.getCartId());
        model.addAttribute("orderDetails", orderDetails);
        model.addAttribute("entries", entries);

        return "orderDetails";
    }
}