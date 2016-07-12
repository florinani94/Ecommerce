package com.evozon.service;

import com.evozon.dao.ProductDAO;
import com.evozon.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if ((product.getCode()!=null) &&(product.getName()!=null)) {
            return true;
        }
        return false;
    }
}
