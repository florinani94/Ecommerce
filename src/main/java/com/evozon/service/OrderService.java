package com.evozon.service;

import com.evozon.dao.OrderDAO;
import com.evozon.domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderDAO orderDAO;

    public Orders getOrderByKey(String orderKey) {
        return orderDAO.getOrderByKey(orderKey);
    }

    public void addOrder(Orders order) {
        orderDAO.addOrder(order);
    }

    public void updateOrder(Orders order) { orderDAO.updateOrder(order); }

}
