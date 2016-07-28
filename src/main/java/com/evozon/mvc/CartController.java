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
    public MiniCartDTO getCartProducts(Model model, @RequestParam("cartId") Integer cartId){
        MiniCartDTO minicart = cartService.getEntriesFromCart(cartId);

        return minicart;
    }

    @RequestMapping(value="", method = RequestMethod.GET)
    public String viewDataFromCart(Model model){
        // get cart id here from cookie

        model.addAttribute("entries", cartService.getAllEntriesFromCart(1));
        model.addAttribute("total", cartService.getCartById(1).getTotal());
        return "viewCart";
    }

    @RequestMapping(value="", method = RequestMethod.POST)
    public String removeDataFromCart(@RequestParam(value = "entryId", required = false) int id, Model model){
        cartService.deleteEntryFromCart(id, 1);
    @RequestMapping(value="/removeFromCart", method = RequestMethod.POST)
    public String removeDataFromCart(@RequestParam(value = "entryId") int entryId, @RequestParam(value = "cartId") int cartId){
        cartService.deleteEntryFromCart(entryId, cartId);
        return "viewCart";
    }

    @RequestMapping(value = "/addToCart", method = RequestMethod.POST)
    @ResponseBody
    public String addToCart(@RequestParam String productId, @RequestParam String cartId, @RequestParam String quantity){
        String message;
        message=cartService.addProductToCart(Integer.parseInt(productId),Integer.parseInt(cartId),Integer.parseInt(quantity));
        return message;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editQuantity(@RequestParam(value = "entryId") int entryId, @RequestParam(value = "newQuantity") int quantity, @RequestParam(value = "cartId") int cartId){
        cartService.editEntry(entryId, cartId, quantity);
        return "viewCart";
    }

    @RequestMapping(value = "/getProductsNumber", method = RequestMethod.GET)
    @ResponseBody
    public int getCartProductsNumber(@RequestParam(value = "cartId") Integer cartId){
        return cartService.getNumberOfProductsInCart(cartId);
    }

}
