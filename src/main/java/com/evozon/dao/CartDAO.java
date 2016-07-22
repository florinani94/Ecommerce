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

    Cart getCartById(Integer id);

    void addCart(Cart cart);

    void deleteCart(Integer id) ;

    void deleteEntry(Integer entryId);

    void updateEntryDetails(Entry entry);

    void addEntryToCart(Integer productId, Integer cartId);//entry was here

    void deleteEntryFromCart(Integer id);

    void updateQuantity(Entry entry);

    List<Entry> getEntryForAdding(Integer productId, Integer cartId);

    List<Entry> getAllEntriesFromCart(Integer id);

    void updateSubTotalForEntry(Double value, Integer entryId,Integer cartId);

    void computeSubTotalForEntry(Integer id,Integer cartId);

    void computeTotalForCart(Integer cartId);

    void updateEntry(Entry e);

    void updateAddress(Cart cart);
}
