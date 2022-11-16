package com.example.demo.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

//@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MonitoringControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void checkPingResponse() {
        ResponseEntity<String> serverResponse = restTemplate.getForEntity("/ping", String.class);
        int responseCode = serverResponse.getStatusCodeValue();
        assertThat(responseCode == 200);
        assertThat(serverResponse.equals("OK"));
    }
}
