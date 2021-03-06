package com.shop.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    // private static final String url = "http://localhost:8086/products/";
    private static final String url = "http://product/products/";

    private final RestTemplate restTemplate;

    @Override
    @HystrixCommand(commandKey = "productInfo", fallbackMethod = "getProductInfoFallback")
    public String getProductInfo(String productId) {
        // Step-2 테스트
        // return restTemplate.getForObject(url + productId + "/fallback", String.class);
        return restTemplate.getForObject(url + productId, String.class);
    }

    public String getProductInfoFallback(String productId, Throwable t) {
        log.info("input : {}, Throwable Message: {}", productId, t.getMessage());

        return "[This Product is Sold Out]";
    }
}
