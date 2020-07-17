package com.tsheppard01.assetmanager.assetrequest.services;

import com.tsheppard01.assetmanager.assetrequest.dto.AssetRequestDto;
import com.tsheppard01.assetmanager.assetrequest.entities.Request;
import com.tsheppard01.assetmanager.assetrequest.entities.RequestItem;
import com.tsheppard01.assetmanager.assetrequest.entities.RequestStatus;
import com.tsheppard01.assetmanager.assetrequest.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class RequestService {

  @Autowired
  RequestRepository requestRepository;

  @Transactional
  public UUID addItemToRequest(AssetRequestDto assetRequestDto) {

    List<RequestItem> items = assetRequestDto.getItems().stream().map(dto ->
        new RequestItem(
            dto.getId(),
            dto.getAssetTypeId(),
            dto.getComments()
          )
        ).collect(Collectors.toList());

    Request request = new Request(
        assetRequestDto.getId(),
        assetRequestDto.getUserId(),
        RequestStatus.valueOf(assetRequestDto.getStatus()),
        Timestamp.valueOf(LocalDateTime.now()),
        items
    );

    request.getRequestItems().forEach(i -> i.setRequest(request));

    Request addedRequest = requestRepository.saveAndFlush(request);

    return addedRequest.getId();
  }

  public UUID createRequest(UUID userId) {

    Request addedRequest = requestRepository
        .saveAndFlush(
            new Request(
                userId,
                RequestStatus.IN_PROGRESS,
                Timestamp.valueOf(LocalDateTime.now())
            )
        );

    return addedRequest.getId();
  }
}
