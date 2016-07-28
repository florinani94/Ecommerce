package com.evozon.mvc;

import com.evozon.domain.Entry;
import com.evozon.domain.Product;
import com.evozon.domain.dtos.MiniCartDTO;
import com.evozon.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(value="", method = RequestMethod.GET)
    public String viewDataFromCart(Model model){
        // get cart id here from cookie

        model.addAttribute("entries", cartService.getAllEntriesFromCart(4));
        model.addAttribute("total", cartService.getCartById(4).getTotal());
        return "viewCart";
    }

    @RequestMapping(value="", method = RequestMethod.POST)
    public String removeDataFromCart(@RequestParam(value = "entryId", required = false) int id, Model model){
        cartService.deleteEntryFromCart(id, 4);
        return "viewCart";
    }

    @RequestMapping(value = "/addToCart", method = RequestMethod.POST)
    @ResponseBody
    public String addToCart(ModelMap model, @RequestParam String productId, @RequestParam String cartId, @RequestParam String quantity){
        String message;
        message=cartService.addProductToCart(Integer.parseInt(productId),Integer.parseInt(cartId),Integer.parseInt(quantity));
        return message;
    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editQuantity(@RequestParam(value = "entryId") int entryId, @RequestParam(value = "newQuantity") int quantity, Model model){
        // get cart id here from cookie
        cartService.editEntry(entryId, 4, quantity);
        return "viewCart";
    }

    @RequestMapping(value = "/getProductsNumber", method = RequestMethod.GET)
    @ResponseBody
    public int getCartProductsNumber(@RequestParam(value = "cartId") int cartId){
        return cartService.getNumberOfProductsInCart(cartId);
    }

}
