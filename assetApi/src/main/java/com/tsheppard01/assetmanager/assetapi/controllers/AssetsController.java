package com.tsheppard01.assetmanager.assetapi.controllers;

import com.tsheppard01.assetmanager.assetapi.dto.AssetDto;
import com.tsheppard01.assetmanager.assetapi.dto.AssetTypeDto;
import com.tsheppard01.assetmanager.assetapi.services.AssetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AssetsController {

  @Autowired
  private AssetTypeService assetTypeService;

  @GetMapping("/assetTypes")
  public ResponseEntity<List<AssetTypeDto>> getAssetTypes() {

    return new ResponseEntity<>(
        assetTypeService.getAllAssetTypes(),
        HttpStatus.OK
    );
  }

  @GetMapping("/assets")
  public ResponseEntity<List<AssetDto>> getAssets() {

    return new ResponseEntity<>(
        assetTypeService.getAllAssets(),
        HttpStatus.OK
    );
  }
}
