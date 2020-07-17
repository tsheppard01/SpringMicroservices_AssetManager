package com.tsheppard01.assetmanager.assetrequest.controllers;

import com.tsheppard01.assetmanager.assetrequest.dto.*;
import com.tsheppard01.assetmanager.assetrequest.entities.Request;
import com.tsheppard01.assetmanager.assetrequest.repository.RequestRepository;
import com.tsheppard01.assetmanager.assetrequest.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import javax.xml.ws.Response;
import java.util.List;
import java.util.UUID;

@RestController
public class RequestController {

  @Autowired
  private RequestService requestService;

  @Autowired
  private RequestRepository repo;

  @PostMapping("/request/additem")
  public ResponseEntity<UUID> addItemToRequest(@RequestBody AssetRequestDto requestDto) {

    return new ResponseEntity<>(
        requestService.addItemToRequest(requestDto),
        HttpStatus.OK
    );
  }

  @PostMapping("/requests/create")
  public ResponseEntity<UuidWrapperDto> createRequest(@RequestBody UuidWrapperDto userId) {

    return new ResponseEntity<> (
        new UuidWrapperDto(
            requestService.createRequest(userId.getId())
        ),
        HttpStatus.OK
    );
  }

  @RequestMapping("requests/users/{userId}")
  public ResponseEntity<List<RequestSummaryDto>> getUserRequestsSummary(@PathVariable(name = "userId") UUID userId) {

    return new ResponseEntity<>(
        requestService.getRequestsSummaryForUserId(userId),
        HttpStatus.OK
    );
  }

  @RequestMapping("requests/{requestId}")
  public ResponseEntity<RequestDto> getRequestDetails(@PathVariable(name = "requestId") UUID requestId) {

    return new ResponseEntity<>(
        requestService.getRequestDetails(requestId),
        HttpStatus.OK
    );
  }

  @GetMapping("/requests")
  public ResponseEntity<List<Request>> getAllRequests() {

    return new ResponseEntity<>(
        repo.findAll(), HttpStatus.OK
    );
  }

  @PostMapping("/requests/{id}/addItem")
  public ResponseEntity<UuidWrapperDto> addItemToRequest(@PathVariable(name = "id") UUID requestId,
                                                         @RequestBody RequestItemDto requestItemDto) {

    return new ResponseEntity<>(
        new UuidWrapperDto(
            requestService.addItemToRequest(requestId, requestItemDto)
        ),
        HttpStatus.OK
    );
  }
}
