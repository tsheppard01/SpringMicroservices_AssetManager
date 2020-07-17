package com.tsheppard01.assetmanager.externalapp.services;

import com.tsheppard01.assetmanager.externalapp.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class RequestsService {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private AssetsService assetsService;

  public UUID createNewRequest(UUID userId) {

      UuidWrapperDto requestId =
        restTemplate
            .postForObject(
                "http://asset-requests-api/requests/create",
                new UuidWrapperDto(userId),
                UuidWrapperDto.class
            );

    return requestId.getId();
  }

  public UUID addItemToRequest(UUID requestId, RequestItemDto requestItemDto) {

    UuidWrapperDto requestItemId =
        restTemplate
            .postForObject(
                "http://asset-requests-api/requests/" + requestId + "/addItem",
                requestItemDto,
                UuidWrapperDto.class
            );

    return requestItemId.getId();
  }

  public List<RequestSummaryDto> getRequestsForUser(UUID userId) {

    RequestSummaryDto[] requestSummaryDtos =
        restTemplate
            .getForObject(
                "http://asset-requests-api/requests/users/" + userId,
                RequestSummaryDto[].class
            );

    return Arrays.asList(requestSummaryDtos);
  }

  public RequestDetailsDto getRequestDetails(UUID requestId) {

    RequestDto request = restTemplate
        .getForObject("http://asset-requests-api/requests/" + requestId,
            RequestDto.class
        );

    List<RequestItemDetailsDto> assets = request.getItems().stream()
        .map(i -> {
          AssetTypeDto asset = assetsService.getAssetType(i.getAssetTypeId());
          return new RequestItemDetailsDto(asset.getName(), asset.getCategory(), i.getComment());
        }).collect(Collectors.toList());

    return
        new RequestDetailsDto(
            request.getId(),
            request.getStatus(),
            request.getDateTimeCreated(),
            assets
        );
  }

  public void submitRequest(UUID requestId) {

    Boolean success = restTemplate
        .postForObject(
            "http://asset-requests-api/requests/" + requestId + "/submit",
            null,
            BooleanWrapperDto.class
        ).isValue();
  }

}
