package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query(value = "FROM Product p left join p.orders op where op.id=:orderId")
    // select * from product_table p
    //      left join order_product op
    //      on order_product.product_id = product_table.id
    //      where order_product.order_id = 2
    public List<Product> getAllProductsByOrderId(Long orderId);

}