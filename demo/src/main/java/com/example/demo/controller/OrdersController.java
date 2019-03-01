package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.model.OrderStatus;
import com.example.demo.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrdersController {

    private final OrderRepository orderRepository;

    public OrdersController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @RequestMapping("/orders")
    public List<Order> getAllOrders() {

        List<Order> target = new ArrayList<>();
        orderRepository.findAll().forEach(target::add);
        return target;
    }

    @RequestMapping("/orders/{id}")
    public Order getOrder(@PathVariable("id") long id) {
        return orderRepository.findById(id).get();
    }

    @RequestMapping(name = "/orders/{id}/status", method = RequestMethod.PATCH)
    public Order finalizeOrder(@PathVariable("id") long id) {
        Order order = orderRepository.findById(id).get();
        order.setOrderStatus(OrderStatus.DELIVERED);
        return order;
    }

    @RequestMapping(name = "/orders", method = RequestMethod.PUT)
    public Order updateOrder(@RequestParam Order order) {
        return orderRepository.save(order);

    }

    @RequestMapping(name = "/orders", method = RequestMethod.DELETE)
    public void deleteOrder(@RequestParam long id) {
        orderRepository.deleteById(id);
    }

}