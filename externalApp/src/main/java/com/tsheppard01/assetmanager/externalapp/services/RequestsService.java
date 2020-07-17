package com.tsheppard01.assetmanager.externalapp.services;

import com.tsheppard01.assetmanager.externalapp.dto.UuidWrapperDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
public class RequestsService {

  @Autowired
  private RestTemplate restTemplate;

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
}
