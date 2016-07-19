package com.evozon.dao;

import com.evozon.domain.Product;

/**
 * Created by vladblana on 19/07/2016.
 */
public interface CartDAO {
    void addProductToCart(Product product);
}
