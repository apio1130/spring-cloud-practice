package com.shop.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/{productId}")
    public String getProductDetail(@PathVariable String productId) {
        return String.format("[product ID = %s at %s]", productId, System.currentTimeMillis());
    }
}
