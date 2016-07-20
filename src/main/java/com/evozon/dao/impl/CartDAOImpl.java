package com.evozon.dao.impl;

import com.evozon.dao.CartDAO;
import com.evozon.domain.Cart;
import com.evozon.domain.Category;
import com.evozon.domain.Entry;
import com.evozon.domain.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vladblana on 19/07/2016.
 */

@Repository("CartDAO")
@Transactional
public class CartDAOImpl implements CartDAO{


   @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addCart(Cart cart) {
        Session session = sessionFactory.getCurrentSession();
        session.save(cart);
    }

    @Override
    public void deleteCart(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query=session.createQuery("DELETE FROM Cart WHERE cartId=:id");
        query.setParameter("id", id);
        query.executeUpdate();

    }
    @Override
    public void addEntryToCart(Entry entry) {
        Session session = sessionFactory.getCurrentSession();
        session.save(entry);
    }

    @Override
    public void deleteEntryFromCart(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query=session.createQuery("DELETE FROM entry WHERE entryId=:id");
        query.setParameter("id", id);
        query.executeUpdate();

    }
    @Override
    public void addProductToEntry(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.save(product);
    }


    @Override
    public Double computeSubTotalForEntry(Integer id){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT (price * quantity) AS subtotal FROM product JOIN entry ON entry.product=product.code JOIN cart ON cart.cartId=entry.cart_id WHERE entry.entryId=:id");
        query.setParameter("id", id);
        List<Double> entries = query.list();
        if(entries.size() > 0){
            return entries.get(0);
        }
        return null;


    }

    @Override
    public Double computeTotalForCart(Integer id){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM cart WHERE cart.cartId = :id");
        query.setParameter("id", id);
        List<Cart> carts = query.list();
        Double total=new Double(0);

        if(carts.size() > 0){
            for(Entry e:carts.get(0).getentrySet()){
                total+=e.getSubTotal();
            }
            return total;
        }
        return null;


    }
}
