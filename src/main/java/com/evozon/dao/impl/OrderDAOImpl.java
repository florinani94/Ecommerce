package com.evozon.dao.impl;

import com.evozon.dao.OrderDAO;
import com.evozon.domain.Orders;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("orderDAO")
@Transactional
public class OrderDAOImpl implements OrderDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Orders getOrderByKey(String orderKey) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Order as O WHERE orderKey = :orderKey");
        query.setParameter("orderKey", orderKey);

        List<Orders> orders = query.list();

        return orders.get(0);
    }

    public void addOrder(Orders order) {
        Session session = sessionFactory.getCurrentSession();
        session.save(order);
    }

}
