package com.yang.order.feign;

import com.yang.order.entity.Product;
import com.yang.order.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "product")
public interface ProductFeign {

    @GetMapping("/product")
    String product(@SpringQueryMap Product product, @RequestHeader("yang") String yang);

    @PostMapping("/product")
    String product(@RequestBody Product product);

    @PutMapping("/product/{id}")
    Result product(@PathVariable("id") Integer id);
}
