package com.evozon.dao;

import com.evozon.domain.*;

import java.util.List;
import java.util.Set;

/**
 * Created by vladblana on 19/07/2016.
 */
public interface CartDAO {
    Product getProductById(Integer productId);

    Entry getEntryById(Integer entryId);

    Cart getCartById(Integer cartId);

    void addCart(Cart cart);

    void updateCart(Cart cart);

    void deleteCart(Integer cartId) ;

    void updateEntryDetails(Entry entry);

    Entry addEntryToCart(Product product, Cart cart, Orders orders);

    void deleteEntryFromCart(Integer entryId);

    void updateQuantity(Entry entry);

    List<Entry> getEntryForAdding(Integer productId, Integer cartId);

    List<Entry> getAllEntriesFromCart(Integer cartId);

    void updateSubTotalForEntry(Double value, Integer entryId,Integer cartId);

    Double computeSubTotalForEntry(Integer id,Integer cartId);

    void computeTotalForCart(Integer cartId);

    void updateEntry(Entry e);

    void updateAddress(Cart cart);
}
