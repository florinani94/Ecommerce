package com.evozon.mvc;

import com.evozon.domain.Category;
import com.evozon.domain.Product;
import com.evozon.mvc.validator.ProductValidator;
import com.evozon.service.CartService;
import com.evozon.service.CategoryService;
import com.evozon.service.ProductService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;
import javax.xml.transform.sax.SAXSource;
import java.io.*;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.multipart.MultipartFile;



@Controller
@RequestMapping(value = "/backoffice/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CartService cartService;
    @Autowired
    private ProductValidator validator;

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAllProducts(Model model) {
        model.addAttribute("allProducts", productService.getAllProducts());
        return "viewProducts";
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteProduct(Model model, @RequestParam("productId") int productId) {
        try {
            productService.deleteImage(productId);
            productService.deleteProduct(productId);

            model.addAttribute("result", true);
            model.addAttribute("allProducts", productService.getAllProducts());
        } catch (Exception e) {
            model.addAttribute("result", false);
        }
        return "viewProducts";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String goToCreateProductPage(Model model) {
        model.addAttribute("allCategories", categoryService.getAllCategories());
        model.addAttribute("product", new Product());
        return "createProduct";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String getResultForCreateProductPage(Model model, @ModelAttribute("product") Product product, BindingResult result,
                                                SessionStatus status,@RequestParam(value = "categoryId", required = false) Integer categoryId,
                                                @RequestParam(value = "image", required = false) MultipartFile image) {

        //validation
        validator.validate(product,result);

        //check validation errors
        if(result.hasErrors()){
            model.addAttribute("allCategories", categoryService.getAllCategories());
            return "createProduct";
        }

        //store the product in database
        Category category = categoryService.getCategoryById(categoryId);
        product.setCategory(category);
        productService.addProduct(productService.doImageSaveOperation(product, image));

        //mark session complete
        status.setComplete();

        model.addAttribute("allProducts", productService.getAllProducts());
        return "viewProducts";

    }

    @RequestMapping(value = "/import", method = RequestMethod.GET)
    public String importFromFile(Model model) {
        model.addAttribute("allProducts", productService.getAllProducts());
        return "viewProducts";
    }

    @RequestMapping(value = "/import", method = RequestMethod.POST)
    public String importFromFile(HttpServletRequest request, Model model) {
        productService.importFromCSV(request);

        model.addAttribute("allProducts", productService.getAllProducts());
        return "viewProducts";
    }

    @RequestMapping(value = "/export", method = RequestMethod.POST)
    public String export(Model model, @RequestBody JsonArray prodArray) {
        List<Integer> productsIds = new Gson().fromJson(prodArray, new TypeToken< List<Integer>>(){}.getType());
        String fileName = "exportProducts";
        List<Product> products = productService.getParticularProducts(productsIds);
        productService.exportToCSV(fileName, products);
//        model.addAttribute("export", productService.validateExport("exportProducts"));
        return "exportProducts";
    }

    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public String export(Model model) {
        model.addAttribute("export", productService.validateExport("exportProducts"));
        return "exportProducts";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editProduct(Model model, @ModelAttribute("product") Product product, BindingResult result, SessionStatus status,@RequestParam(value = "categoryId", required = false) Integer categoryId, @RequestParam(value = "image", required = false) MultipartFile image) {

        //validation
        validator.validate(product,result);

        //check validation errors
        if(result.hasErrors()){
            model.addAttribute("allCategories", categoryService.getAllCategories());
            return "editProduct";
        }
        //update product in database
        Category category = categoryService.getCategoryById(categoryId);
        product.setCategory(category);
        productService.updateProduct(productService.doImageSaveOperation(product, image));

        //mark session complete
        status.setComplete();

        model.addAttribute("allProducts", productService.getAllProducts());
        return "viewProducts";
    }


    @RequestMapping(value = "/edit/{productId}", method = RequestMethod.GET)
    public String goToCreateProductPage(@PathVariable("productId") int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("allCategories", categoryService.getAllCategories());
        model.addAttribute("product", product);
        return "editProduct";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String deleteAll(Model model, @RequestParam(value = "prodArray[]") List<Integer> prodArray) {
        for (Integer i : prodArray) {
            productService.deleteProduct(i);
        }
        return "viewProducts";
    }

    @RequestMapping(value = "/downloadCSV", method = RequestMethod.GET)
    public void downloadCSV(HttpServletResponse response) throws IOException {

        String filePath = "../bin/exportProducts.csv";
        File file = new File(filePath).getAbsoluteFile();

        if(!file.exists()){
            String errorMessage = "Sorry. The file you are looking for does not exist";
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
            outputStream.close();
            return;
        }
        String mimeType= URLConnection.guessContentTypeFromName(file.getName());
        if(mimeType==null){
            mimeType = "application/octet-stream";
        }

        response.setContentType(mimeType);
        response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
        response.setContentLength((int)file.length());

        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        OutputStream outputStream = response.getOutputStream();

        FileCopyUtils.copy(inputStream, outputStream);

        inputStream.close();
        outputStream.close();
        file.delete();
    }

}
