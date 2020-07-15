package com.tsheppard01.assetmanager.externalapp.config;

import com.tsheppard01.assetmanager.externalapp.clients.CustomRestTemplateCustomizer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ExternalAppConfig {

  @Bean
  @LoadBalanced
  public RestTemplate createRestTemplate() {
    return new RestTemplateBuilder(new CustomRestTemplateCustomizer()).build();
  }
}
