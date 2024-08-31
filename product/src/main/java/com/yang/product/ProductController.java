package com.yang.product;

import com.yang.product.entity.Product;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping
    public String product(Product product,@RequestHeader("yang") String yang) {
        return yang;
    }

    @PostMapping
    public String product(@RequestBody Product product) {
        return product.getName();
    }

    @PutMapping("/{id}")
    public Integer product(@PathVariable("id") Integer id) {
        if (true){
            throw new RuntimeException("zzz");
        }
        return id;
    }
}
