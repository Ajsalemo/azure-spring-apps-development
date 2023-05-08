package com.springapps.azure.Controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {
    @Value("${cloud.name}")
    private String cloudName;

    public String azureSpringAppsApplicationName = "Azure Spring App Name: " + this.cloudName;

    @GetMapping("/api/config/client")
    public String configClient() {
        return cloudName;
    }
}
