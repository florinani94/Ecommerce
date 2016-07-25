package com.evozon.dao;

import com.evozon.domain.Order;

public interface OrderDAO {

    public Order getOrderById(int id);

    public void addOrder(Order order);

}
