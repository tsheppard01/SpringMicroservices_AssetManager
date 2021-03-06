package com.tsheppard01.assetmanager.assetrequest.services;

import com.tsheppard01.assetmanager.assetrequest.dto.RequestDto;
import com.tsheppard01.assetmanager.assetrequest.dto.RequestItemDto;
import com.tsheppard01.assetmanager.assetrequest.dto.RequestSummaryDto;
import com.tsheppard01.assetmanager.assetrequest.entities.Request;
import com.tsheppard01.assetmanager.assetrequest.entities.RequestItem;
import com.tsheppard01.assetmanager.assetrequest.entities.RequestStatus;
import com.tsheppard01.assetmanager.assetrequest.repository.RequestItemRepository;
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

  @Autowired
  RequestItemRepository requestItemRepository;

  @Transactional
  public UUID addItemToRequest(UUID requestId, RequestItemDto requestItemDto) {

    return
        requestRepository
            .findById(requestId)
            .map(request ->
                new RequestItem(
                    requestItemDto.getAssetTypeId(),
                    requestItemDto.getComment(),
                    request
                )
            ).map(request ->
                requestItemRepository.saveAndFlush(request)
            ).map(RequestItem::getId)
            .orElseThrow(() ->
                new IllegalArgumentException("Error retrieving request with Id:" + requestId)
            );
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

  public List<RequestSummaryDto> getRequestsSummaryForUserId(UUID userId) {

    return requestRepository.findAllByUserId(userId)
        .stream().map(r ->
            new RequestSummaryDto(
                r.getId(),
                r.getUserId(),
                r.getStatus().toString(),
                r.getDateTimeCreated().toLocalDateTime()
            )
        ).collect(Collectors.toList());
  }

  public RequestDto getRequestDetails(UUID requestId) {

    return
    requestRepository.findById(requestId)
        .map(r ->
            new RequestDto(
                r.getId(),
                r.getUserId(),
                r.getStatus().toString(),
                r.getDateTimeCreated().toLocalDateTime(),
                r.getRequestItems().stream().map(ri ->
                    new RequestItemDto(
                        ri.getId(),
                        ri.getAssetTypeId(),
                        ri.getComment()
                    )
                ).collect(Collectors.toList()))
        ).orElseThrow(() ->
          new IllegalArgumentException("Error retrieving request with Id:" + requestId)
      );
  }

  public boolean submitRequest(UUID requestId) {

    boolean success = requestRepository.findById(requestId)
        .map(r -> {
          r.setStatus(RequestStatus.SUBMITTED);
          requestRepository.saveAndFlush(r);
          return true;
        })
    .orElse(false);

    if(success){
      // could put code here to call on to the request management service to create
      // a new case for that service
      // could also emit an async message here to say a request has been submitted
    }

    return success;
  }
}
