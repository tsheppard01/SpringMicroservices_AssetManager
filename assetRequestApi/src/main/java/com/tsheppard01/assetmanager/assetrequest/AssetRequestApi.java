package com.tsheppard01.assetmanager.assetrequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AssetRequestApi {

	public static void main(String[] args) {
		SpringApplication.run(AssetRequestApi.class, args);
	}

}
