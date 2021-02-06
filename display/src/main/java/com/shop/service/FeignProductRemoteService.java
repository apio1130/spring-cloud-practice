package com.shop.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="product")
public interface FeignProductRemoteService {
    @GetMapping("/products/{productId}")
    String getProductInfo(@PathVariable("productId") String productId);
}
