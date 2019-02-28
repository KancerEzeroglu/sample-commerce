package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_table")
public class Product {

    @Id
    @GeneratedValue
    private long id;

    private String title;

    @ManyToMany( mappedBy = "products")
    private List<Order> orders;

    public Product() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}