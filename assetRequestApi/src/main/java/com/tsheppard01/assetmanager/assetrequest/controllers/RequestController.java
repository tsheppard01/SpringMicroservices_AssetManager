package com.tsheppard01.assetmanager.assetrequest.controllers;

import com.tsheppard01.assetmanager.assetrequest.dto.AssetRequestDto;
import com.tsheppard01.assetmanager.assetrequest.dto.UuidWrapperDto;
import com.tsheppard01.assetmanager.assetrequest.entities.Request;
import com.tsheppard01.assetmanager.assetrequest.repository.RequestRepository;
import com.tsheppard01.assetmanager.assetrequest.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

  @GetMapping("/requests")
  public ResponseEntity<List<Request>> getAllRequests() {

    return new ResponseEntity<>(
        repo.findAll(), HttpStatus.OK
    );
  }
}
