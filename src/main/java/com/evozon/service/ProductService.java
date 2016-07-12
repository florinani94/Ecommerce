package com.evozon.service;

import com.evozon.dao.ProductDAO;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by horatiucernean on 12/07/2016.
 */

@Transactional
public class ProductService
{
    private ProductDAO productDAO;

    public void setProductDAOImpl(ProductDAO productDAO ) {
        this.productDAO = productDAO;
    }

    public void addProduct(Product product) {
        this.productDAO.addProduct(product);
    }

}
