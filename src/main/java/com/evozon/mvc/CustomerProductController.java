package com.evozon.mvc;


import com.evozon.domain.Product;
import com.evozon.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(value = "products")
public class CustomerProductController {

    public static final int MAX_PRODUCTS_PER_PAGE= 9;

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllProducts(Model model, @RequestParam(value = "page", defaultValue = "1") Integer startPageIndex ) {

        model.addAttribute("products", productService.getProductsForPage(startPageIndex, MAX_PRODUCTS_PER_PAGE));
        model.addAttribute("productSize", productService.getSize());
        model.addAttribute("currentPage",startPageIndex);
        return "customerViewProducts";
    }

    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public String getSortedProducts(@RequestParam(value = "sortValue") String sortValue, Model model, @RequestParam(value = "page", defaultValue = "1") Integer startPageIndex) {

//        if (sortedProducts.isEmpty()){
//            sortedProducts = productService.getSortedProducts(sortValue);
//            model.addAttribute("products", sortedProducts);
//            //model.addAttribute("products", productService.getSortedProducts(sortValue));
//            model.addAttribute("productSize", productService.getSize());
//            model.addAttribute("currentPage",startPageIndex);
//        }


        return "customerViewProducts";
    }

}
