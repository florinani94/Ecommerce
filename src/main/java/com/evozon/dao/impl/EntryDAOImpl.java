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
        Query query=session.createQuery("DELETE FROM Cart WHERE entryId=:id");
        query.setParameter("id", id);
        query.executeUpdate();

    }
    @Override
    public void addProductToEntry(Product product) {
        Session session = sessionFactory.getCurrentSession();
        Query query=session.createQuery("DELETE FROM Cart WHERE entryId=:id");
    }
}
