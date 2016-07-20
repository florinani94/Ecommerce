package com.evozon.mvc;


import com.evozon.domain.Product;
import com.evozon.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping(value = "products")
public class CustomerProductController {

    public static final int MAX_PRODUCTS_PER_PAGE= 9;

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllProducts(@RequestParam(value = "sortValue", defaultValue = "none") String sortValue, Model model, @RequestParam(value = "page", defaultValue = "1") Integer startPageIndex ) {

        model.addAttribute("products", productService.getSortedProducts(sortValue,startPageIndex, MAX_PRODUCTS_PER_PAGE));
        model.addAttribute("productSize", productService.getSize());
        model.addAttribute("currentPage",startPageIndex);
        model.addAttribute("sortValue",sortValue);
        return "customerViewProducts";
    }

    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public String getSortedProducts(@RequestParam(value = "sortValue") String sortValue, Model model, @RequestParam(value = "page", defaultValue = "1") Integer startPageIndex) {

        model.addAttribute("products", productService.getSortedProducts(sortValue,startPageIndex, MAX_PRODUCTS_PER_PAGE));
        model.addAttribute("productSize", productService.getSize());
        model.addAttribute("currentPage",startPageIndex);

        return "customerViewProducts";
    }

    @RequestMapping(value = "/address", method = RequestMethod.GET)
    public String gotToCheckoutPage(Model model) {
        model.addAttribute("cart", new Product());
        return "customerCartCheckout";
    }

    @RequestMapping(value = "/address", method = RequestMethod.POST)
    public String checkoutAddress(Model model, @ModelAttribute("product") Product product, BindingResult data) {
        try {
            if (!data.hasErrors()) {
                model.addAttribute("data", true);
            } else if (data.hasErrors()) {
                model.addAttribute("data", false);
                return "customerCartCheckout";
            }
        } catch (Exception e) {
            model.addAttribute("data", false);
        }
        return "customerCartCheckout";
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String showProductDetails(Model model, @RequestParam String productId){
        model.addAttribute("theProduct", productService.getProductById(Integer.parseInt(productId)));
        return "productDetailsPage";
    }
}
