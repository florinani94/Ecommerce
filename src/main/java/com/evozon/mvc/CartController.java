package com.evozon.mvc;

import com.evozon.domain.Entry;
import com.evozon.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashSet;
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
    public Set<Entry> getCartProducts(Model model, @RequestParam("cartId") int cartId){
        System.out.println(cartId+"/////");
        Set<Entry> entries = cartService.getEntriesFromCart(cartId);
        return entries;
    }


    @RequestMapping(value="/populate", method = RequestMethod.GET)
    public String insertEntryProducts(Model model){
        System.out.println("Populated");
        cartService.addProductToCart(1,1);
        cartService.addProductToCart(2,1);
        cartService.addProductToCart(3,1);
        cartService.addProductToCart(5,2);
        cartService.addProductToCart(6,2);
        return "splashPage";
    }

}
