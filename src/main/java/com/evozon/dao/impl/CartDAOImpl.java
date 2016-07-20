package com.evozon.dao.impl;
/*
import com.evozon.dao.CartDAO;
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
/*
@Repository("CartDAO")
@Transactional
public class CartDAOImpl implements CartDAO{


   @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addProductToCart(Product product) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Product as P WHERE P.productId = :id");
        query.setParameter("id", product.getProductId());
    }

}
*/