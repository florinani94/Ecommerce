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
    public Product getProductById(Integer productId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Product as P WHERE P.productId = :id");
        query.setParameter("id", productId);
        List<Product> products = query.list();
        if(products.size() > 0){
            return products.get(0);
        }
        return null;
    }

    @Override
    public Cart getCartById(Integer cartId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Cart as C WHERE C.cartId = :id");
        query.setParameter("id", cartId);
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
    //doesn't work
    public void deleteCart(Integer cartId) {
        Session session = sessionFactory.getCurrentSession();
        Query query=session.createQuery("DELETE FROM Cart as C WHERE C.cartId=:id");
        query.setParameter("id", cartId);
        query.executeUpdate();
    }

    @Override
    public void deleteEntry(Integer entryId) {
        Session session = sessionFactory.getCurrentSession();
        Query query=session.createQuery("DELETE FROM Entry as E WHERE E.entryId=:id");
        query.setParameter("id", entryId);
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
        session.save(entry);
        updateEntryDetails(entry);
    }

    @Override
    public void deleteEntryFromCart(Integer entryId) {
        Session session = sessionFactory.getCurrentSession();
        Query query=session.createQuery("DELETE FROM Entry as E WHERE E.entryId=:id");
        query.setParameter("id", entryId);
        query.executeUpdate();
    }

    @Override
    public void updateQuantity(Entry entry) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(entry);
    }


    @Override
    public List<Entry> getEntriesFromCart(Integer productId, Integer cartId) {
        Session session = sessionFactory.getCurrentSession();
        Query query=session.createQuery("Select E FROM Entry as E, Product as P, Cart as C WHERE E.cart=C.cartId AND P.productId=E.product AND C.cartId=:id AND P.productId=:prodId");
        query.setParameter("id", cartId);
        query.setParameter("prodId", productId);
        List<Entry> entryList=query.list();
        return entryList;
    }

    @Override
    public Set<Entry> getAllEntriesFromCart(Integer cartId) {
        Session session = sessionFactory.getCurrentSession();
        Query query=session.createQuery("FROM Entry as E WHERE E.cart=:id");
        query.setParameter("id", cartId);
        return (Set<Entry>)query.list();
    }

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
    public void computeSubTotalForEntry(Integer entryId,Integer cartId){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT E FROM Entry as E, Product as P,Cart as C WHERE E.entryId=:id AND C.cartId=:cId AND E.cart=C.cartId");
        query.setParameter("id", entryId);
        query.setParameter("cId", cartId);

        ArrayList<Entry> result = (ArrayList)query.list();

        Double value=new Double(result.get(0).getQuantity()*result.get(0).getProductPrice());
        updateSubTotalForEntry(value,entryId,cartId);


    }

    @Override
    public void computeTotalForCart(Integer cartId){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Cart as C WHERE C.cartId = :id");
        query.setParameter("id", cartId);
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

    @Override
    public void updateEntry(Entry e) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(e);
    }
}
