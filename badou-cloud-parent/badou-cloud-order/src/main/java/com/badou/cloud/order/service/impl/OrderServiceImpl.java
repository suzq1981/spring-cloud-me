package com.badou.cloud.order.service.impl;

import com.badou.cloud.order.dao.OrderMapper;
import com.badou.cloud.order.entity.Order;
import com.badou.cloud.order.service.OrderSercie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderSercie {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void createOrder(Order order) {
        order.setDate(new Date());
        orderMapper.createOrder(order);
    }

    @Override
    public Order findOrderById(Integer orderId) {
        return orderMapper.findOrderById(orderId);
    }

    @Override
    public void cancelOrder(Integer orderId, Integer state) {
        orderMapper.cancelOrder(orderId, state);
    }

    @Override
    public void updateOrder(Order order) {
        order.setDate(new Date());
        orderMapper.updateOrder(order);
    }

    @Override
    public List<Order> findOrderByCondition(Order condition) {
        System.out.println(condition);
        return orderMapper.findOrderByCondition(condition);
    }
}
