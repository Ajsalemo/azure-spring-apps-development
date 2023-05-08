package com.springapps.azure.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    String message = "azure-spring-apps-spring-boot-basic-config-server-local";

    @GetMapping("/")
    public String index() {
        return message;
    }
}
