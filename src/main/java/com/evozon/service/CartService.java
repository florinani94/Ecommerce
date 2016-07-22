package com.evozon.service;

import com.evozon.dao.CartDAO;
import com.evozon.domain.Cart;
import com.evozon.domain.Entry;
import com.evozon.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.util.List;
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

    public void updateCart(Integer cartId){
        Cart cart=cartDAO.getCartById(cartId);
        cartDAO.updateCart(cart);
    }

    public void deleteCart(Integer cartId){
        List<Entry> entryList=cartDAO.getAllEntriesFromCart(cartId);
        for(Entry e:entryList){
            cartDAO.deleteEntryFromCart(e.getEntryId());
        }
        cartDAO.deleteCart(cartId);
    }

    public void editEntry(Integer entryId,Integer cartId,Integer quantity){
        Entry entry=cartDAO.getEntryById(entryId);
        entry.setQuantity(quantity);
        if(entry.getQuantity()==0){
            cartDAO.deleteEntryFromCart(entry.getEntryId());
            cartDAO.computeTotalForCart(cartId);
        }
        else {
            if (entry.getProduct().getStockLevel() < entry.getQuantity()) {
                entry.setQuantity(entry.getProduct().getStockLevel());
            }
            cartDAO.updateQuantity(entry);
            Double subTotal = cartDAO.computeSubTotalForEntry(entry.getEntryId(), cartId);
            cartDAO.updateSubTotalForEntry(subTotal, entry.getEntryId(), cartId);
            cartDAO.computeTotalForCart(cartId);
        }

    }
/*
    public void editEntry(Entry entry,Integer cartId){
        if(entry.getQuantity()==0){
            cartDAO.deleteEntryFromCart(entry.getEntryId());
        }
        else if(entry.getProduct().getStockLevel()>entry.getQuantity()){
            entry.setQuantity(entry.getProduct().getStockLevel());
            cartDAO.updateQuantity(entry);
            cartDAO.computeSubTotalForEntry(entry.getEntryId(),cartId);
        }
    }
*/
    public void addProductToCart(Integer productId,Integer cartId) {
        List<Entry> entryList=cartDAO.getEntryForAdding(productId,cartId);
        if(entryList.size()>0){
            for(Entry e:entryList){
                if(e.getProductCode()!=null) {
                    e.setQuantity(e.getQuantity() + 1);
                    cartDAO.updateEntry(e);
                    Double subTotal = cartDAO.computeSubTotalForEntry(e.getEntryId(), cartId);
                    cartDAO.updateSubTotalForEntry(subTotal, e.getEntryId(), cartId);
                    cartDAO.computeTotalForCart(cartId);
                }
            }
        }
        else{
            Entry entry=cartDAO.addEntryToCart(productId,cartId);
            cartDAO.updateEntryDetails(entry);
//            Double subTotal=cartDAO.computeSubTotalForEntry(entry.getEntryId(),cartId);
//            cartDAO.updateSubTotalForEntry(subTotal,entry.getEntryId(),cartId);
//            cartDAO.computeTotalForCart(cartId);
            addProductToCart(productId,cartId);
        }
    }

    public void deleteEntryFromCart(Integer entryId, Integer cartId) {
        cartDAO.deleteEntryFromCart(entryId);
        cartDAO.computeTotalForCart(cartId);
    }


}
