package com.springapps.azure.Controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {
    @Value("azure.spring-apps.name")
    public static String azureSpringAppName;

    public static String name = "Azure Spring App Name: " + (azureSpringAppName != "" ? azureSpringAppName : "Undefined");

    @GetMapping("/api/config/client")
    public String configClient() {
        return name;
    }
}
