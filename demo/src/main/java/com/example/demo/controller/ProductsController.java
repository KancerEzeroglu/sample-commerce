package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductsController {

    private final ProductRepository productRepository;

    public ProductsController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping("/products")
    public List<Product> getAllProducts() {

        List<Product> target = new ArrayList<>();
        productRepository.findAll().forEach(target::add);
        return target;

    }

    @RequestMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") long id) {

        return productRepository.findById(id).get();

    }
}