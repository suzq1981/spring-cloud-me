package com.badou.cloud.order.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private Integer orderId;
    private String orderSeq;
    private Date date;
    private int state;
    private Integer userId;

}
