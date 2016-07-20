package com.evozon.mvc;

import com.evozon.domain.Product;
import com.evozon.service.ProductService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by florinani on 19/07/2016.
 */

@Controller
@RequestMapping(value = "/rest/product")
public class RestProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping(value = "", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
    @ResponseBody
    public String getAllProducts(HttpServletResponse response) {

        List<Product> products = productService.getAllProducts();
        String productList = new Gson().toJson(products);
        if(products.size() == 0 ){
            response.setStatus(404);
        }
        response.setStatus(200);
        return productList;
    }


    @RequestMapping(value = "/{productId}", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
    @ResponseBody
    public String getProduct(@PathVariable int productId, HttpServletResponse response) {

        Product product = productService.getProductById(productId);
        String jsonProduct = new Gson().toJson(product);
        if (product != null) {
            response.setStatus(200);
            return jsonProduct;
        }
        response.setStatus(404);
        return  new Gson().toJson(" The product with id " + productId + " does not exists!");
    }


    @RequestMapping(value = "/{productId}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteProduct(@PathVariable int productId , HttpServletResponse response) {

        Product product = productService.getProductById(productId);
        if (product != null) {
            response.setStatus(200);
            productService.deleteProduct(productId);
            return "The product with id " + productId + " have been deleted !";
        }
        response.setStatus(404);
        return "The product with id " + productId + " does not exists !";
    }


    @RequestMapping(value = "", method = RequestMethod.PUT, headers = "Accept=application/json", produces = "application/json", consumes = "application/json")
    @ResponseBody
    public String updateProduct(@RequestBody Product product, HttpServletResponse response) {

        Product searchedProduct = productService.getProductById(product.getProductId());
        if (searchedProduct != null) {
            response.setStatus(200);
            productService.updateProduct(product);
            return new Gson().toJson(" The product with id " + product.getProductId() + " have been updated!");
        }
        response.setStatus(404);
        return new Gson().toJson(" The product with id " + product.getProductId() + " does not exists!");
    }


    @RequestMapping(value = "", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json", consumes = "application/json")
    @ResponseBody
    public String addProduct(@RequestBody Product product, HttpServletResponse response) {

        Product searchedProduct = productService.getProductByCode(product.getCode());
        if (searchedProduct == null) {
            response.setStatus(200);
            productService.addProduct(product);
            return new Gson().toJson(" The product was successfully added !");
        }
        response.setStatus(404);
        return new Gson().toJson(" The product with code " + product.getCode() + " already exists!");
    }

}
