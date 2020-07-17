package com.tsheppard01.assetmanager.externalapp.services;

import com.tsheppard01.assetmanager.externalapp.dto.AddRequestItemDto;
import com.tsheppard01.assetmanager.externalapp.dto.AssetRequestDto;
import com.tsheppard01.assetmanager.externalapp.dto.AssetRequestItemDto;
import com.tsheppard01.assetmanager.externalapp.dto.AssetTypeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
public class AssetsService {

  @Autowired
  private RestTemplate restTemplate;

  public List<AssetTypeDto> getAllAssetTypes() {

    return Arrays.asList(
            restTemplate.getForObject("http://asset-api/assetTypes", AssetTypeDto[].class)
        );
  }

  public AssetTypeDto getAssetType(UUID assetTypeId) {
    return restTemplate.getForObject("http://asset-api/assetTypes/" + assetTypeId, AssetTypeDto.class);
  }

  public String addItemToRequest(AddRequestItemDto addRequestItem) {

    AssetRequestDto requestDto = new AssetRequestDto(
        null,
        addRequestItem.getUserId(),
        "IN_PROGRESS",
        Arrays.asList(
            new AssetRequestItemDto(
                null,
                addRequestItem.getAssetTypeId(),
                "This is a comment"
            )
        )
    );

    return restTemplate.postForObject("http://asset-requests-api/request/additem", requestDto, String.class);
  }
}
