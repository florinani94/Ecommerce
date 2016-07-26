package com.evozon.dao;

import com.evozon.domain.Orders;

public interface OrderDAO {

    public Orders getOrderByKey(String orderKey);

    public void addOrder(Orders order);

}
