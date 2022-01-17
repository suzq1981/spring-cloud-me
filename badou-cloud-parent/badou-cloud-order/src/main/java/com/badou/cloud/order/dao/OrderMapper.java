package com.badou.cloud.order.dao;

import com.badou.cloud.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderMapper {

    void createOrder(Order order);

    Order findOrderById(Integer orderId);

    void cancelOrder(Integer orderId, Integer state);

    void updateOrder(Order order);

    List<Order> findOrderByCondition(Order condition);

}
