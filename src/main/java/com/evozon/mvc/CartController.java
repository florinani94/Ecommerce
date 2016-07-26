package com.evozon.mvc;

import com.evozon.domain.Entry;
import com.evozon.domain.Product;
import com.evozon.domain.dtos.MiniCartDTO;
import com.evozon.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by mateimihai on 7/21/2016.
 */

@Controller
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping(value="/entries", method = RequestMethod.POST)
    @ResponseBody
    public MiniCartDTO getCartProducts(Model model, @RequestParam("cartId") int cartId){
        MiniCartDTO minicart = cartService.getEntriesFromCart(cartId);

        return minicart;
    }


    @RequestMapping(value="/populate", method = RequestMethod.GET)
    public String insertEntryProducts(Model model){
        System.out.println("Populated");
        //cartService.addProductToCart(1,1);
      //  cartService.addProductToCart(2,1);
      //  cartService.addProductToCart(3,1);
      //  cartService.addProductToCart(5,2);
      //  cartService.addProductToCart(6,2);
        return "splashPage";
    }

    @RequestMapping(value="/view", method = RequestMethod.GET)
    public String viewDataFromCart(Model model){
        // get cart id here from cookie

//        Product p = new Product();
//        p.setProductId(1);
//        p.setImageURL("/resources/productImages/default@product.jpg");
//
//        Entry e = new Entry();
//        e.setProductName("Super Good Tea");
//        e.setProductCode("123456");
//        e.setProductPrice(5.43);
//        e.setQuantity(2);
//        e.setSubTotal(345.3);
//        e.setProduct(p);
//
//
//        Product p2 = new Product();
//        p2.setProductId(2);
//        p2.setImageURL("/resources/productImages/default@product.jpg");
//
//        Entry e2 = new Entry();
//        e2.setProductName("Super Good Tea2");
//        e2.setProductCode("364");
//        e2.setProductPrice(5.43);
//        e2.setQuantity(9);
//        e2.setSubTotal(345.3);
//        e2.setProduct(p2);
//
//        List<Entry> entries = new ArrayList<Entry>();
//        entries.add(e);
//        entries.add(e2);
//
//        model.addAttribute("entries", entries);
        return "viewCart";
    }

    @RequestMapping(value = "/addToCart", method = RequestMethod.POST)
    public String addToCart(Model model, @RequestParam String productId, @RequestParam String cartId, @RequestParam String quantity){
        System.out.println("//Prod id://"+productId);
        // model.addAttribute("theProduct", productService.getProductById(Integer.parseInt(productId)));
        cartService.addProductToCart(Integer.parseInt(productId),Integer.parseInt(cartId),Integer.parseInt(quantity));
        return "productDetailsPage";
    }

}
