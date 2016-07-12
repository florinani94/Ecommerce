package com.evozon.service;

import com.evozon.dao.ProductDAO;
import com.evozon.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by horatiucernean on 12/07/2016.
 */

@Service
public class ProductService {

    @Autowired
    private ProductDAO productDAO;

    public void setProductDAOImpl(ProductDAO productDAO ) {
        this.productDAO = productDAO;
    }

    public boolean validateProduct(Product product)
    {
        if ((product.getCode()!=null) &&(product.getName()!=null)) {
            return true;
        }
        return false;
    }
    public void addProduct(Product product) {
       this.productDAO.addProduct(product);

    }
}
