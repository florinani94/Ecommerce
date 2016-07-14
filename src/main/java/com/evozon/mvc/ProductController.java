package com.evozon.mvc;

        import com.evozon.domain.Product;
        import com.evozon.service.ProductService;
        import org.apache.commons.fileupload.FileItem;
        import org.apache.commons.fileupload.disk.DiskFileItemFactory;
        import org.apache.commons.fileupload.servlet.ServletFileUpload;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
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
@RequestMapping(value = "/backoffice")
public class ProductController {

    @Autowired
    private ProductService productService;

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);


    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getAllProducts(Model model) {

        model.addAttribute("allProducts", productService.getAllProducts());

        return "viewProducts";
    }


    @RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
    public String deleteProduct(Model model, @RequestParam("productId") int productId) {
        try {
            productService.deleteProduct(productId);
            //todo: give meaningful name
            model.addAttribute("message", true);
            model.addAttribute("allProducts", productService.getAllProducts());
        } catch(Exception e) {
            model.addAttribute("message", false);
        }
        return "viewProducts";
    }


    @RequestMapping(value = "/createProduct", method = RequestMethod.GET)
    public String goToCreateProductPage(Model model) {
        model.addAttribute("product", new Product());
        return "createProduct";
    }


    @RequestMapping(value = "/createProduct", method = RequestMethod.POST)
    public String result(Model model, @ModelAttribute("product") Product product, BindingResult result) {

        try {
            productService.addProduct(product);
            model.addAttribute("message", true);
            if (result.hasErrors() || productService.validateProduct(product) == false) {
                model.addAttribute("message", false);
                return "createProduct";
            }
        } catch (Exception e) {
            model.addAttribute("message", false);
        }

        return "createProduct";

    }

    @RequestMapping(value = "/import", method = RequestMethod.GET)
    public String importFromFile(Model model) {
        model.addAttribute("allProducts", productService.getAllProducts());

        return "viewProducts";
    }

    @RequestMapping(value = "/import", method = RequestMethod.POST)
    public String importFromFile(HttpServletRequest request, Model model) {
        File file;
        String contentType = request.getContentType();
        if ((contentType.indexOf("multipart/form-data") >= 0)) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            try {
                List fileItems = upload.parseRequest(request);
                Iterator i = fileItems.iterator();
                while (i.hasNext()) {
                    FileItem fi = (FileItem) i.next();
                    if (!fi.isFormField()) {
                        file = new File("temp.csv");
                        fi.write(file);
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        productService.importFromFile("temp.csv");
        model.addAttribute("allProducts", productService.getAllProducts());
        return "viewProducts";
    }

    @RequestMapping(value = "/exportproducts", method = RequestMethod.GET)
    public String export(Model model) {

        String fileName = "exportProducts";
        productService.exportToCSV(fileName);
        model.addAttribute("export", productService.validateExport(fileName));

        return "exportProducts";
    }
    @RequestMapping(value = "/editProduct", method = RequestMethod.POST)
    public String editProduct(Model model, @ModelAttribute("product") Product product, BindingResult result){
        productService.updateProduct(product);
        model.addAttribute("allProducts", productService.getAllProducts());
        return "viewProducts";
    }

    @RequestMapping(value = "/edit/{productId}", method = RequestMethod.GET)
    public String goToCreateProductPage(@PathVariable("productId") int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "editProduct";
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public String deleteAll(Model model, @RequestParam(value="prodArray[]") List<Integer> prodArray) {
        for (Integer i : prodArray) {
            productService.deleteProduct(i);
        }
        return "redirect:/";
    }
}
