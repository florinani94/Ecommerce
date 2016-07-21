package com.evozon.dao;

import com.evozon.domain.Cart;
import com.evozon.domain.Entry;
import com.evozon.domain.Product;

import java.util.List;
import java.util.Set;

/**
 * Created by vladblana on 19/07/2016.
 */
public interface CartDAO {
    Product getProductById(Integer id);

    Cart getCartById(Integer id);

    void addCart(Cart cart);
    void deleteCart(Integer id) ;

    void deleteEntry(Integer entryId);

    void updateEntryDetails(Entry entry);

    Entry addEntryToCart(Integer productId, Integer cartId);

    void deleteEntryFromCart(Integer id);
    void updateQuantity(Entry entry);

    List<Entry> getEntriesFromCart(Integer productId, Integer cartId);

    Set<Entry> getAllEntriesFromCart(Integer id);
    void updateSubTotalForEntry(Double value, Integer entryId,Integer cartId);

    void computeSubTotalForEntry(Integer id,Integer cartId);

    void computeTotalForCart(Integer cartId);

    void updateEntry(Entry e);
}
