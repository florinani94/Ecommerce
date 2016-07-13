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
        import org.springframework.web.bind.annotation.ModelAttribute;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.RequestParam;

        import javax.servlet.http.HttpServletRequest;
        import java.io.File;
        import java.util.Iterator;
        import java.util.List;

/**
 * Created by horatiucernean on 12/07/2016.
 */

@Controller
@RequestMapping(value = "backoffice")
public class ProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getAllProducts(Model model) {

        productService.addDefaultProducts();
        model.addAttribute("allProducts", productService.getAllProducts());

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
        return "importProducts";
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
        return "importProducts";
    }

    @RequestMapping(value = "/exportproducts", method = RequestMethod.GET)
    public String export(Model model) {

        String fileName = "exportProducts";
        productService.exportToCSV(fileName);
        model.addAttribute("export", productService.validateExport(fileName));

        return "exportProducts";
    }
}
