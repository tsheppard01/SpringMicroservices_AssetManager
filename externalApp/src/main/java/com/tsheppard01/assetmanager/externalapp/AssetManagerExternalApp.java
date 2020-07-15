package com.tsheppard01.assetmanager.externalapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AssetManagerExternalApp {

	public static void main(String[] args) {
		SpringApplication.run(AssetManagerExternalApp.class, args);
	}

}
