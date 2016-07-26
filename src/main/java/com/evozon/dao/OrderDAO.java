package com.evozon.dao;

import com.evozon.domain.Entry;
import com.evozon.domain.Orders;

import java.util.List;

public interface OrderDAO {

    public Orders getOrderByKey(String orderKey);

    public Orders getOrderById(Integer orderId);

    public void addOrder(Orders order);

    public List<Entry> getAllEntries(Integer orderId);

}
