package com.evozon.dao;

import com.evozon.domain.Cart;
import com.evozon.domain.Entry;
import com.evozon.domain.Product;

import java.util.Set;

/**
 * Created by vladblana on 19/07/2016.
 */
public interface CartDAO {
    void addCart(Cart cart);
    void deleteCart(Integer id) ;
    void addEntryToCart(Entry entry);

    void deleteEntryFromCart(Integer id);

    void addProductToEntry(Product product);

    Set<Entry> getAllEntriesFromCart(Integer id);
    void updateSubTotalForEntry(Double value, Integer entryId,Integer cartId);

    void computeSubTotalForEntry(Integer id);

    void computeTotalForCart(Integer id);
}
