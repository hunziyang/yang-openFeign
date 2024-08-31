package com.yang.order.controller;

import com.yang.order.entity.Product;
import com.yang.order.feign.ProductFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private ProductFeign productFeign;

    @GetMapping("/product")
    public Integer gerProduct() {
        Product product = new Product();
        product.setName("yang-zzz");
        return productFeign.product(12);
    }
}
