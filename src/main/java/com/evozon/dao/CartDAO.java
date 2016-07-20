package com.evozon.dao;

import com.evozon.domain.Cart;
import com.evozon.domain.Entry;
import com.evozon.domain.Product;

/**
 * Created by vladblana on 19/07/2016.
 */
public interface CartDAO {
    void addCart(Cart cart);
    void deleteCart(int id) ;
    void addEntryToCart(Entry entry);

    void deleteEntryFromCart(int id);

    void addProductToEntry(Product product);

    Double computeSubTotalForEntry(Integer id);

    Double computeTotalForCart(Integer id);
}
