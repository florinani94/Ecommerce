package com.evozon.dao;

import com.evozon.domain.AddressDTO;
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

    Entry getEntryById(Integer entryId);

    Cart getCartById(Integer id);

    void addCart(Cart cart);

    void updateCart(Cart cart);

    void deleteCart(Integer id) ;

    void updateEntryDetails(Entry entry);

    Entry addEntryToCart(Integer productId, Integer cartId);//entry was here

    void deleteEntryFromCart(Integer entryId);

    void updateQuantity(Entry entry);

    List<Entry> getEntryForAdding(Integer productId, Integer cartId);

    List<Entry> getAllEntriesFromCart(Integer id);

    void updateSubTotalForEntry(Double value, Integer entryId,Integer cartId);

    Double computeSubTotalForEntry(Integer id,Integer cartId);

    void computeTotalForCart(Integer cartId);

    void updateEntry(Entry e);

    void updateAddress(Cart cart);
}
