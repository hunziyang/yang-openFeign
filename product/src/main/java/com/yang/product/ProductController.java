package com.yang.product;

import com.yang.product.entity.Product;
import com.yang.product.result.CoreResultCode;
import com.yang.product.result.Result;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

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
    public Result product(@PathVariable("id") Integer id, HttpServletResponse httpServletResponse) {
//        if (true){
//            throw new RuntimeException("zzz");
//        }
        httpServletResponse.setStatus(500);
        return Result.error(CoreResultCode.INTERNAL_SERVER_ERROR);
    }
}
