package com.springapps.azure.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListRegisteredInstances {
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/api/eureka/get/instances", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ServiceInstance> listRegisteredInstances() {

        List<String> services = discoveryClient.getServices();
        List<ServiceInstance> instances = new ArrayList<ServiceInstance>();
        services.forEach(serviceName -> {
            discoveryClient.getInstances(serviceName).forEach(instance -> {
                instances.add(instance);
            });
        });
        return instances;
    }
}
