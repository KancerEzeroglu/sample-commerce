package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrdersController {

    @RequestMapping("/orders")
    public List<Order> getAllOrders() {

    }

    @RequestMapping("/orders/{id}")
    public Order getOrder(@PathVariable("id") long id) {

    }

    @RequestMapping("/orders/{id}/products")
    public List<Product> getOrderProducts(@PathVariable("id") long id) {

    }

    @RequestMapping("/orders/{id}/status", method = RequestMethod.PATCH)
    public List<Product> getOrderProducts(@PathVariable("id") long id, @RequestParam("status") OrderStatus status) {

    }

    @RequestMapping("/orders")
    public Order createOrder() {

    }

    @RequestMapping("/orders")
    public Order deleteOrder() {

    }
}