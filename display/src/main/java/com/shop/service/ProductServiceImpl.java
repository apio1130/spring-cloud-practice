package com.shop.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private static final String url = "http://localhost:8086/products/";

    private final RestTemplate restTemplate;

    @Override
    public String getProductInfo(String productId) {
        return restTemplate.getForObject(url + productId, String.class);
    }
}
