package com.evozon.dao;

import com.evozon.domain.Cart;
import com.evozon.domain.Product;

/**
 * Created by vladblana on 19/07/2016.
 */
public interface CartDAO {
    void addCart(Cart cart);
    void deleteCart(int id) ;
}
