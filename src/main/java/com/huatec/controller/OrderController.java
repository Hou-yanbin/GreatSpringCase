package com.huatec.controller;

import com.huatec.domain.Order;
import com.huatec.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/orderList")
    public ModelAndView orderList(ModelAndView modelAndView){
//        System.out.println(orderService);
        List<Order> orderList = orderService.orderList();
        modelAndView.addObject("orderList",orderList);
        modelAndView.setViewName("order-list");
        return modelAndView;
    }
    @RequestMapping("/del/{orderId}")
    public String del(@PathVariable("orderId") String orderId){
//        System.out.println(orderService);
        orderService.delOrder(orderId);

        return "redirect:/order/orderList";
    }
}
