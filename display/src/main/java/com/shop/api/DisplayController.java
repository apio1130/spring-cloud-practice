package com.shop.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/displays")
@RequiredArgsConstructor
public class DisplayController {

    private final ProductService productService;

    @GetMapping("/{displayId}")
    public String getDisplayDetail(@PathVariable String displayId) {
        String productInfo = getProductInfo();
        return String.format("[display ID = %s at %s %s]", displayId, System.currentTimeMillis(), productInfo);
    }

    private String getProductInfo() {
        return productService.getProductInfo("12345");
    }
}
