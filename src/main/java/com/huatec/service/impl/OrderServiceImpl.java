package com.huatec.service.impl;

import com.huatec.domain.Order;
import com.huatec.mapper.OrderMapper;
import com.huatec.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> orderList() {
        List<Order> orderList = orderMapper.orderList();
        return orderList;
    }

    @Override
    public void delOrder(String orderId) {
        orderMapper.delOrder(orderId);
    }
}
