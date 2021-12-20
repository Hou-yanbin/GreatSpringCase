package com.huatec.mapper;

import com.huatec.domain.Order;

import java.util.List;

public interface OrderMapper {

    List<Order> orderList();

    void delOrder(String orderId);
}
