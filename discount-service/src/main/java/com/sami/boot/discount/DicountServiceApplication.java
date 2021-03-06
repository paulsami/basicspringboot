package com.sami.boot.discount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DicountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DicountServiceApplication.class, args);
	}

}
