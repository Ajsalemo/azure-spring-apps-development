package com.springapps.azure.Controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${cloud.name}")
    private String cloudName;

    @GetMapping("/api/config/client")
    public String configClient() {
        return "Azure Spring App Name: " + cloudName;
    }
}

