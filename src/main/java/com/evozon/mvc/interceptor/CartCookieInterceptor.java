package com.evozon.mvc.interceptor;

import com.evozon.domain.Cart;
import com.evozon.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartCookieInterceptor implements HandlerInterceptor {

    @Autowired
    private CartService cartService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        Cookie[] cookies = httpServletRequest.getCookies();

        if (cookies != null) {
            Integer flag = 0;
            for (Cookie cookie : cookies)
                if ("cartId".equals(cookie.getName())) {
                    System.out.println("The cookie exists and we put the cart from DB to the user session");
                    flag = 1;
                }
            //the cookie was not found on request
            if (flag == 0) {
                //1. Create a new Cart if cart not exist
                Cart newCart = new Cart();
                cartService.addCart(newCart);
                System.out.println("Cart created");

                //2. Create a new Cookie with the cartId
                Cookie newCookie = new Cookie("cartId", String.format("%s", newCart.getCartId()));
                newCookie.setMaxAge(43200); //The time the cookie can be eaten is 12 hours
                httpServletResponse.addCookie(newCookie);
                System.out.println("Cookie created");

                //3. Put Cart on user Session
                System.out.println("Cart put on session");
            }

        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
