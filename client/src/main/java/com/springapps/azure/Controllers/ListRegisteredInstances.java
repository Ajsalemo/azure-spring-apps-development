package com.springapps.azure.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ListRegisteredInstances {
    @GetMapping("/api/eureka/get/instances")
    public String apiController() {
        final String uri = "http://localhost:8761/eureka/apps";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        System.out.println(result);

        return result;
    }
}
