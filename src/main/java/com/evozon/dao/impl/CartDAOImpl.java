package com.evozon.dao.impl;

import com.evozon.dao.CartDAO;
import com.evozon.domain.Cart;
import com.evozon.domain.Entry;
import com.evozon.domain.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by vladblana on 19/07/2016.
 */

@Repository("CartDAO")
@Transactional
public class CartDAOImpl implements CartDAO{


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Product getProductById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Product as P WHERE P.productId = :id");
        query.setParameter("id", id);
        List<Product> products = query.list();
        if(products.size() > 0){
            return products.get(0);
        }
        return null;
    }

    @Override
    public Cart getCartById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Cart as C WHERE C.cartId = :id");
        query.setParameter("id", id);
        List<Cart> carts = query.list();
        if(carts.size() > 0){
            return carts.get(0);
        }
        return null;
    }
    @Override
    public void addCart(Cart cart) {
        Session session = sessionFactory.getCurrentSession();
        session.save(cart);

    }

    @Override
    public void deleteCart(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Query query=session.createQuery("DELETE FROM Cart as C WHERE C.cartId=:id");
        query.setParameter("id", id);
        query.executeUpdate();

    }
    @Override
    public void updateEntryDetails(Entry entry){
        Session session = sessionFactory.getCurrentSession();
        Product product=entry.getProduct();
        entry.setProductCode(product.getCode());
        entry.setProductName(product.getName());
        entry.setProductPrice(product.getPrice());
        session.save(entry);
    }

    @Override
    public void addEntryToCart(Integer productId, Integer cartId){
        Session session = sessionFactory.getCurrentSession();
        Entry entry=new Entry(getCartById(cartId),getProductById(productId),new Integer(0),new Double(0.0));
        updateEntryDetails(entry);
    }

    @Override
    public void deleteEntryFromCart(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Query query=session.createQuery("DELETE FROM Entry as E WHERE E.entryId=:id");
        query.setParameter("id", id);
        query.executeUpdate();

    }


    @Override
    public void addProductToCart(Integer productId, Integer cartId) {
        Session session = sessionFactory.getCurrentSession();
        Query query=session.createQuery("FROM Entry as E WHERE E.cart=:id AND E.product=:prodId");
        query.setParameter("id", cartId);
        query.setParameter("prodId", productId);
        Set<Entry> entrySet=(Set<Entry>)query.list();
        if(entrySet.size()>0){
            for(Entry e:entrySet){
                e.setQuantity(e.getQuantity()+1);
                session.saveOrUpdate(e);
                computeSubTotalForEntry(e.getEntryId());
            }
        }
        else{
            addEntryToCart(productId,cartId);
            addProductToCart(productId,cartId);

        }

    }

    @Override
    public Set<Entry> getAllEntriesFromCart(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Query query=session.createQuery("FROM Entry as E WHERE E.cart=:id");
        query.setParameter("id", id);
        return (Set<Entry>)query.list();
    }
    //// TODO: 20/07/2016 deleteProductFromEntry 

    @Override
    public void updateSubTotalForEntry(Double value, Integer entryId,Integer cartId){
        Session session = sessionFactory.getCurrentSession();
        Query query=session.createQuery("FROM Entry as E WHERE E.entryId=:id");
        query.setParameter("id", entryId);
        List<Entry> entries=query.list();
        if(entries.size()>0){
            entries.get(0).setSubTotal(value);
        }
        session.saveOrUpdate(entries.get(0));
        computeTotalForCart(cartId);
    }

    @Override
    public void computeSubTotalForEntry(Integer id){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT E.quantity, P.price, C.cartId FROM Entry as E, Product as P,Cart as C WHERE E.entryId=:id AND C.cartId= E.cart");
        query.setParameter("id", id);
        query.list();

        ArrayList<Object> result = (ArrayList)query.list();

        Object[] entry = (Object[])result.get(0);
        Double value=new Double((Integer)entry[0]*(Double)entry[1]);
        updateSubTotalForEntry(value,id,(Integer)entry[2]);


    }

    @Override
    public void computeTotalForCart(Integer id){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Cart as C WHERE C.cartId = :id");
        query.setParameter("id", id);
        List<Cart> carts = query.list();

        if(carts.size() > 0){
            Double total=new Double(0);
            for(Entry e:carts.get(0).getEntrySet()){
                total+=e.getSubTotal();

            }
            carts.get(0).setTotal(total);
        }

        session.saveOrUpdate(carts.get(0));
    }
}
