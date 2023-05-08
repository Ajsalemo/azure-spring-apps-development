package com.springapps.azure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class AzureApplication {

	public static void main(String[] args) {
		SpringApplication.run(AzureApplication.class, args);
	}

}
