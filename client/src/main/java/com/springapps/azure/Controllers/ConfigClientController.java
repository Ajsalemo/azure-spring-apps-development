package com.springapps.azure.Controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${azure.name}")
    private String cloudName;

    public String azureSpringAppsApplicationName = "Azure Spring App Name: " + this.cloudName;

    @GetMapping("/api/config/client")
    public String configClient() {
        return cloudName;
    }
}
