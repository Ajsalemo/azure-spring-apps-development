package com.springapps.azure.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    String msg = "azure-spring-apps-spring-boot-basic";

    @GetMapping("/")
    public String index() {
        return msg;
    }
}