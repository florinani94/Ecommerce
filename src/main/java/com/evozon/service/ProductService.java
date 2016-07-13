package com.evozon.service;

import com.evozon.dao.ProductDAO;
import com.evozon.domain.Product;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Iterator;
import java.util.List;


@Service
public class ProductService
{
    @Autowired
    private ProductDAO productDAO;

    public void addProduct(Product product) {
        this.productDAO.addProduct(product);
    }


    public List<Product> getAllProducts(){
        return productDAO.getAllProducts();
    }


    public void addDefaultProducts(){
        productDAO.addDefaultProducts();
    }

    public boolean validateProduct(Product product)
    {
        if ((!product.getCode().equals("") && (!product.getName().equals("")))) {
            return true;
        }
        return false;
    }

    public void importFromFile(String filename) {
        productDAO.importFromFile(filename);}
}
