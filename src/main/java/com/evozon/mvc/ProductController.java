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
    private ProductService productService;

    @RequestMapping(value = "/backoffice/createproduct", method = RequestMethod.GET)
    public String goToCreateProductPage() {
        return "createproduct";
    }

}
