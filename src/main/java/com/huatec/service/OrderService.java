package com.huatec.service;

import com.huatec.domain.Order;

import java.util.List;

public interface OrderService {
    List<Order> orderList();

    void delOrder(String orderId);
}
