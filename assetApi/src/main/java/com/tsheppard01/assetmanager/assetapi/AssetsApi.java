package com.tsheppard01.assetmanager.assetapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AssetsApi {

	public static void main(String[] args) {
		SpringApplication.run(AssetsApi.class, args);
	}

}
