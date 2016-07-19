package com.evozon.mvc;

import com.evozon.domain.Product;
import com.evozon.service.ProductService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by florinani on 19/07/2016.
 */

@Controller
@RequestMapping(value = "/rest/product")
public class RestProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping(value = "/list", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
    @ResponseBody
    public String getAllProducts() {

        List<Product> products = productService.getAllProducts();
        String productList = new Gson().toJson(products);

        return productList;
    }


    @RequestMapping(value = "/list/{productId}", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
    @ResponseBody
    public String getProduct(@PathVariable int productId) {

        Product product = productService.getProductById(productId);
        String jsonProduct = new Gson().toJson(product);
        if (product != null) {
            return jsonProduct;
        }
        return "{ \"Error\" : \" The product with id " + productId + " does not exists! \" }";
    }


    @RequestMapping(value = "/delete/{productId}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteProduct(@PathVariable int productId) {

        Product product = productService.getProductById(productId);
        if (product != null) {
            productService.deleteProduct(productId);
            return "The product with id " + productId + " have been deleted !";
        }
        return "The product with id " + productId + " does not exists !";
    }


    @RequestMapping(value = "/update", method = RequestMethod.PUT, headers = "Accept=application/json", produces = "application/json", consumes = "application/json")
    @ResponseBody
    public String updateProduct(@RequestBody Product product) {

        Product searchedProduct = productService.getProductById(product.getProductId());
        if (searchedProduct != null) {
            productService.updateProduct(product);
            return "{ \"Message\" : \" The product with id " + product.getProductId() + " have been updated! \" }";
        }
        return "{ \"Error\" : \" The product with id " + product.getProductId() + " does not exists! \" }";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json", consumes = "application/json")
    @ResponseBody
    public String addProduct(@RequestBody Product product) {

        Product searchedProduct = productService.getProductBycode(product.getCode());
        if (searchedProduct == null) {
            productService.addProduct(product);
            return "{ \"Message\" : \" The product was successfully added ! \" }";
        }
        return "{ \"Error\" : \" The product with code " + product.getCode() + " already exists! \" }";
    }

}
