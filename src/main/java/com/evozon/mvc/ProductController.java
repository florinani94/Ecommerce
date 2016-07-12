package com.evozon.mvc;

        import com.evozon.domain.Product;
        import com.evozon.service.ProductService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by horatiucernean on 12/07/2016.
 */

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/backoffice/createproduct", method = RequestMethod.GET)
    public String goToCreateProductPage() {
        return "createproduct";
    }

    @RequestMapping(value = "/backoffice/createproduct", method = RequestMethod.POST)
    public String getProductDetails(Product product) {
        if (productService.validateProduct(product)) {
            return "redirect:/createproduct/success";
        }
        else
        {
            return "redirect:/createproduct/unsuccess";
        }
    }
    @RequestMapping(value = "/createproduct/success", method = RequestMethod.GET)
    public  String goToCetareProductSuccessPage() {
        return "createproductsuccess";
    }
}
