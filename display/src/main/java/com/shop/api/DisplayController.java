package com.shop.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/displays")
public class DisplayController {

    @GetMapping("/{displayId}")
    public String getDisplayDetail(@PathVariable String displayId) {
        return String.format("[display ID = %s at %s]", displayId, System.currentTimeMillis());
    }
}
