package com.evozon.mvc;

import com.evozon.domain.Product;
import com.evozon.service.ProductService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * Created by horatiucernean on 12/07/2016.
 */

//todo: refactor URLS - can create restful API here
@Controller
@RequestMapping(value = "customer")
public class CustomerProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getAllProducts(Model model, @RequestParam(value = "page", defaultValue = "1") Integer startPageIndex ) {

        productService.addDefaultProducts();

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
