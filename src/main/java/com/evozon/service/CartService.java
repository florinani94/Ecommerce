package com.evozon.service;

import com.evozon.dao.CartDAO;
import com.evozon.domain.Cart;
import com.evozon.domain.Entry;
import com.evozon.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.util.Set;

/**
 * Created by vladblana on 19/07/2016.
 */
@Service
public class CartService {
    @Autowired
    private CartDAO cartDAO;

    @Autowired
    private ServletContext servletContext;

    public void addCart(Cart cart){
        cartDAO.addCart(cart);

    }

    public void deleteCart(Integer id){
        cartDAO.deleteCart(id);

    }

    public void addEntryToCart(Entry entry) {
        cartDAO.addEntryToCart(entry);
    }

    public void deleteEntryFromCart(int id) {
        cartDAO.deleteEntryFromCart(id);
    }

    public void addProductToEntry(Product product) {
        cartDAO.addProductToEntry(product);
    }

    public Double computeSubTotalForEntry(Integer id){
        return cartDAO.computeSubTotalForEntry(id);
    }

    public Double computeTotalForCart(Integer id){
        Set<Entry> entrySet=cartDAO.getAllEntriesForCart(id);
        Double total=new Double(0);
        for(Entry e:entrySet){
            total+=e.getSubTotal();

        }
        return total;
    }
}
