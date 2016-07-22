package com.evozon.service;

import com.evozon.dao.CartDAO;
import com.evozon.domain.Cart;
import com.evozon.domain.Entry;
import com.evozon.domain.dtos.EntryDTO;
import com.evozon.domain.dtos.MiniCartDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;

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

    }

    public void deleteCart(Integer id){
        cartDAO.deleteCart(id);
    }
/*
    public void testEditEntry(Entry entry,Integer cartId){
        if(entry.getQuantity()<0){
            //cannot accept negative values
        }
        if(entry.getQuantity()==0){
            cartDAO.deleteEntry(entry.getEntryId());
        }
        else if(entry.getProduct().getStockLevel()>entry.getQuantity()){
            entry.setQuantity(entry.getProduct().getStockLevel());
            //send a message to say requested quantity is greater than stock level
            cartDAO.updateQuantity(entry);
            cartDAO.computeSubTotalForEntry(entry.getEntryId(),cartId);
        }
    }
*/
    public void editEntry(Entry entry,Integer cartId){
        if(entry.getQuantity()==0){
            cartDAO.deleteEntry(entry.getEntryId());
        }
        else if(entry.getProduct().getStockLevel()>entry.getQuantity()){
            entry.setQuantity(entry.getProduct().getStockLevel());
            cartDAO.updateQuantity(entry);
            cartDAO.computeSubTotalForEntry(entry.getEntryId(),cartId);
        }
    }

    public void addProductToCart(Integer productId,Integer cartId) {
        List<Entry> entryList=cartDAO.getEntryForAdding(productId,cartId);
        if(entryList.size()>0){
            for(Entry e:entryList){
                e.setQuantity(e.getQuantity()+1);
                cartDAO.updateEntry(e);
                cartDAO.computeSubTotalForEntry(e.getEntryId(),cartId);
                cartDAO.computeTotalForCart(cartId);
            }
        }
        else{
            //Entry entry=cartDAO.addEntryToCart(productId,cartId);
            cartDAO.addEntryToCart(productId,cartId);
            //cartDAO.updateEntryDetails(entry);
            addProductToCart(productId,cartId);
        }
    }

    public void deleteEntryFromCart(Entry entry, Integer cartId) {
        cartDAO.deleteEntryFromCart(entry.getEntryId());
        cartDAO.computeSubTotalForEntry(entry.getEntryId(),cartId);
    }


    public MiniCartDTO getEntriesFromCart(Integer cartId){
        Cart cartModel = cartDAO.getCartById(cartId);

        MiniCartDTO minicart = new MiniCartDTO();
        minicart.setTotal(cartModel.getTotal());

        List<Entry> entryList = cartModel.getEntryList();
        ArrayList<EntryDTO> entryDTOList = new ArrayList<>();
        for(Entry entryModel : entryList) {
            EntryDTO entryDTO = new EntryDTO();
            entryDTO.setName(entryModel.getProductName());
            entryDTO.setPrice(entryModel.getProductPrice());
            entryDTO.setQuantity(entryModel.getQuantity());

            entryDTOList.add(entryDTO);
        }

        minicart.setEntries(entryDTOList);

        return minicart;
    }
}
