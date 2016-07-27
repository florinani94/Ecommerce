package com.evozon.servlet;

import com.evozon.domain.Cart;
import com.evozon.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SessionFilter implements Filter{

    @Autowired
    private CartService cartService;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Cookie[] cookies = request.getCookies();

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
                //Cart newCart = new Cart();
                //cartService.addCart(newCart);
                System.out.println("Cart created");

                //2. Create a new Cookie with the cartId
                //Cookie newCookie = new Cookie("cardId", String.format("%s", newCart.getCartId()));
                //newCookie.setMaxAge(43200); //The time the cookie can be eaten is 12 hours
                //response.addCookie(newCookie);
                System.out.println("Cookie created");

                //3. Put Cart on user Session
//                System.out.println("Cart put on session");
            }

        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
