package com.evozon.mvc;

import com.evozon.domain.dtos.MiniCartDTO;
import com.evozon.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;



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
        cartService.addProductToCart(1,1);
        cartService.addProductToCart(2,1);
        cartService.addProductToCart(3,1);
        cartService.addProductToCart(5,2);
        cartService.addProductToCart(6,2);
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
    @ResponseBody
    public String addToCart(@CookieValue(value = "cartId", defaultValue = "0") Integer cookieCartId, Model model,
                            @RequestParam String productId, @RequestParam String cartId, HttpServletResponse response){

        cookieCartId = Integer.parseInt(cartId);

        Cookie cookie = new Cookie("cartId", cookieCartId.toString());
        cookie.setMaxAge(43200); //The time the cookie can be eaten is 12 hours
        response.addCookie(cookie);

//        System.out.println("//Cart id://"+cartId);
//        System.out.println("//Cookie value://"+cookie.getValue());


        return "home";
    }

}
