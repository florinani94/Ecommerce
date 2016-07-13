package com.evozon.mvc;

        import com.evozon.domain.Product;
        import com.evozon.service.ProductService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.validation.BindingResult;
        import org.springframework.web.bind.annotation.ModelAttribute;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by horatiucernean on 12/07/2016.
 */

@Controller
@RequestMapping(value = "backoffice")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/createproduct", method = RequestMethod.GET)
    public String goToCreateProductPage(Model model) {
        model.addAttribute("product", new Product());
        return "createproduct";
    }

    @RequestMapping(value = "/createproduct", method = RequestMethod.POST)
    public String result(Model model, @ModelAttribute("product") Product product, BindingResult result) {

        try {
            productService.addProduct(product);
            model.addAttribute("message", true);
            if (result.hasErrors() && productService.validateProduct(product)) {
                model.addAttribute("message", false);
                return "createproduct";
            }
        }catch (Exception e){
            model.addAttribute("message", false);
        }

        return "createproduct";

    }

}
