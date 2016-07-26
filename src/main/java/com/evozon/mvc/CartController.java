package com.evozon.mvc;

import com.evozon.domain.Entry;
import com.evozon.domain.Product;
import com.evozon.domain.dtos.MiniCartDTO;
import com.evozon.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value="", method = RequestMethod.GET)
    public String viewDataFromCart(Model model){
        // get cart id here from cookie

        model.addAttribute("entries", cartService.getAllEntriesFromCart(1));
        model.addAttribute("total", cartService.getCartById(1).getTotal());
        return "viewCart";
    }

    @RequestMapping(value="/view", method = RequestMethod.POST)
    public String removeDataFromCart(@RequestParam(value = "entryId", required = false) int id, Model model){
        // get cart id here from cookie

        System.out.println(id);

//        cartService.editEntry(id, 1, 0);
//
//        model.addAttribute("entries", cartService.getAllEntriesFromCart(1));
//        model.addAttribute("total", cartService.getCartById(1).getTotal());
        return "viewCart";
    }

    @RequestMapping(value = "/addToCart", method = RequestMethod.POST)
    public String addToCart(Model model, @RequestParam String productId, @RequestParam String cartId, @RequestParam String quantity){
        System.out.println("//Prod id://"+productId);
        // model.addAttribute("theProduct", productService.getProductById(Integer.parseInt(productId)));
        if(cartService.addProductToCart(Integer.parseInt(productId),Integer.parseInt(cartId),Integer.parseInt(quantity))){

        }
        else{

        }
        return "productDetailsPage";
    }

}
