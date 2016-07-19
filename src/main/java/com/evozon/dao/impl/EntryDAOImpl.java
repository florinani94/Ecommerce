package com.evozon.dao.impl;

import com.evozon.dao.EntryDAO;
import com.evozon.domain.Cart;
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
@Repository("EntryDAO")
@Transactional
public class EntryDAOImpl implements EntryDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addEntry(Entry entry) {
        Session session = sessionFactory.getCurrentSession();
        session.save(entry);
    }

    @Override
    public void deleteEntry(int id) {
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
        Query query = session.createQuery("select (price * quantity) as subtotal from product join entry on entry.product=product.code join cart on cart.cartId=entry.cart_id where entry.entryId=:id");
        query.setParameter("id", id);
        List<Double> entries = query.list();
        if(entries.size() > 0){
            return entries.get(0);
        }
        return null;


    }
}
