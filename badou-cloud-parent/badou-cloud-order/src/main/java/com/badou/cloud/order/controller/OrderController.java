package com.badou.cloud.order.controller;

import com.badou.cloud.commons.ResultUtil;
import com.badou.cloud.order.entity.Order;
import com.badou.cloud.order.service.OrderSercie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderSercie orderSercie;

    @PostMapping
    public Order order(@RequestBody Order order) {
        orderSercie.createOrder(order);
        return order;
    }

    @DeleteMapping
    public Map<String, Object> cancle(Integer orderId) {
        orderSercie.cancelOrder(orderId, 2);
        return ResultUtil.OK;
    }

    @PutMapping
    public Map<String, Object> update(@RequestBody Order order) {
        orderSercie.updateOrder(order);
        return ResultUtil.OK;
    }

    @GetMapping("/{id}")
    public Order get(@PathVariable("id") Integer orderId) {
        return orderSercie.findOrderById(orderId);
    }

    @PostMapping(value = "/qry")
    public List<Order> findOrderByCondition(@RequestBody Order order) {
        String token = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).
                getRequest().getHeader("badou-token");
        System.out.println("token===========" + token);
        return orderSercie.findOrderByCondition(order);
    }

}
