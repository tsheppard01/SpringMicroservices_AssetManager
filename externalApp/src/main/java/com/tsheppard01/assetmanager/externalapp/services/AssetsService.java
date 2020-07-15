package com.tsheppard01.assetmanager.externalapp.services;

import com.netflix.discovery.DiscoveryClient;
import com.tsheppard01.assetmanager.externalapp.dto.AssetTypeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class AssetsService {

  @Autowired
  private RestTemplate restTemplate;

  public List<AssetTypeDto> getAllAssetTypes() {

    return Arrays.asList(
            restTemplate.getForObject("http://asset-api/assetTypes", AssetTypeDto[].class)
        );
  }
}
