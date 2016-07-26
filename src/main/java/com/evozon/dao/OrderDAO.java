package com.evozon.dao;

import com.evozon.domain.Entry;
import com.evozon.domain.Orders;

import java.util.List;

/**
 * TODO Remove "public" modifier from interfaces
 * It is permitted, but discouraged as a matter of style, to redundantly specify the public modifier
 * for a method declared in an interface.
 */
public interface OrderDAO {

    public Orders getOrderByKey(String orderKey);

    public Orders getOrderById(Integer orderId);

    public void addOrder(Orders order);

    public void updateOrder(Orders order);


    public void updateOrder(Orders order);

    public List<Entry> getAllEntries(Integer orderId);

}
