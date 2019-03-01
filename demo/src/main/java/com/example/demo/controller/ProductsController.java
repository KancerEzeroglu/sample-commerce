package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductsController {

    private final ProductRepository productRepository;

    public ProductsController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping(name = "/products", method = RequestMethod.GET)
    public List<Product> getAllProducts() {

        List<Product> target = new ArrayList<>();
        productRepository.findAll().forEach(target::add);
        return target;
    }

    @RequestMapping(name = "/products", method = RequestMethod.POST)
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @RequestMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") long id) {
        return productRepository.findById(id).get();
    }

    @RequestMapping("/orders/{id}/products")
    public List<Product> getProductsByOrder(@PathVariable("id") long id){
        return productRepository.getAllProductsByOrderId(id);
    }
}