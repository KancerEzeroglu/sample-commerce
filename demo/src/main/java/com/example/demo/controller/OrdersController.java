package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.model.OrderStatus;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import javax.el.MethodNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class OrdersController {

    @RequestMapping("/orders")
    public List<Order> getAllOrders() {
        throw new MethodNotFoundException();
    }

    @RequestMapping("/orders/{id}")
    public Order getOrder(@PathVariable("id") long id) {
        throw new MethodNotFoundException();
    }

    @RequestMapping("/orders/{id}/products")
    public List<Product> getOrderProducts(@PathVariable("id") long id) {
        throw new MethodNotFoundException();
    }

    @RequestMapping(name = "/orders/{id}/status", method = RequestMethod.PATCH)
    public List<Product> finalizeOrder(@PathVariable("id") long id, @RequestParam("status") OrderStatus status) {
        throw new MethodNotFoundException();
    }

    @RequestMapping(name = "/orders", method = RequestMethod.POST)
    public Order createOrder() {
        throw new MethodNotFoundException();

    }

    @RequestMapping(name = "/orders", method = RequestMethod.PUT)
    public Order updateOrder() {
        throw new MethodNotFoundException();

    }

    @RequestMapping(name = "/orders",method = RequestMethod.DELETE)
    public Order deleteOrder() {
        throw new MethodNotFoundException();

    }

}