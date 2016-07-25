package com.evozon.service;

import com.evozon.dao.OrderDAO;
import com.evozon.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderDAO orderDAO;

    public Order getOrderById(int id) {
        return orderDAO.getOrderById(id);
    }

    public void addOrder(Order order) {
        orderDAO.addOrder(order);
    }

}
