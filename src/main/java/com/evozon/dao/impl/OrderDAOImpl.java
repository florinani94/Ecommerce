package com.evozon.dao.impl;

import com.evozon.dao.OrderDAO;
import com.evozon.domain.Order;
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

    public Order getOrderById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Order as O WHERE orderId = :id");
        query.setParameter("id", id);

        List<Order> orders = query.list();

        return orders.get(0);
    }

}
