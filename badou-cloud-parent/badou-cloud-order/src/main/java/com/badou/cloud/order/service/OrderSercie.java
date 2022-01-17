package com.badou.cloud.order.service;

import com.badou.cloud.order.entity.Order;

import java.util.List;

public interface OrderSercie {

    void createOrder(Order order);

    Order findOrderById(Integer orderId);

    void cancelOrder(Integer orderId, Integer state);

    void updateOrder(Order order);

    List<Order> findOrderByCondition(Order condition);

}
