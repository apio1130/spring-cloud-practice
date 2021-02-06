package com.shop.api;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DisplayControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("displays Detail 요청 확인")
    void getDisplayInfoNormalCaseTest() {
        ResponseEntity<String> response = restTemplate.getForEntity("/displays/123", String.class);
        log.info("response : {}", response);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).contains("This Product is Sold Out");
    }
}