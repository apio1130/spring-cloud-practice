package com.shop.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/{productId}")
    public String getProductDetail(@PathVariable String productId) {
        return String.format("[product ID = %s at %s]", productId, System.currentTimeMillis());
    }

    @GetMapping("/{productId}/fallback")
    public String getProductDetailWithFallback(@PathVariable String productId) {
        // 1. Hystrix의 Fallback 실행 여뷰는 Exception 발생 여뷰
        // throw new RuntimeException("I/O Error");

        // 2. Hystrix로 Timeout 처리
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }

        return String.format("[product ID = %s at %s]", productId, System.currentTimeMillis());
    }
}
