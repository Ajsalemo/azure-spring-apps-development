package com.springapps.azure.Controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {
    @Value("${azure.spring-apps.name}")
    public String azureSpringAppName;

    public String name = "Azure Spring App Name: " + azureSpringAppName;

    @GetMapping("/api/config/client")
    public String configClient() {
        return name;
    }
}
