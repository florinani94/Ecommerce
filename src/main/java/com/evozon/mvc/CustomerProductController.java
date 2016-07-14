package com.evozon.mvc;


import com.evozon.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


//todo: refactor URLS - can create restful API here
@Controller
@RequestMapping(value = "customer")
public class CustomerProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getAllProducts(Model model, @RequestParam(value = "page", defaultValue = "1") Integer startPageIndex ) {

        //todo: extract constants from business logic code
        model.addAttribute("products", productService.getProductsForPage(startPageIndex, 9));
        model.addAttribute("productSize", productService.getSize());
        return "customerViewProducts";
    }


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String goToHome(){

       return "redirect:/customer/products";
    }

}
