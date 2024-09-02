package com.example.hello_bff.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProxyController {
    private final RestTemplate restTemplate;

    // The URL of your core backend
    @Value("${core.backend.url}")
    private String coreBackendUrl;

    public ProxyController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/gethello")
    public String forwardHello() {
        // Forward the request to the core backend
        String coreBackendResponse = restTemplate.getForObject(coreBackendUrl + "/hello", String.class);
        return coreBackendResponse;
    }
}
