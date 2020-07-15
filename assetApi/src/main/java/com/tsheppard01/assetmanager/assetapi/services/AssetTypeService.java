package com.tsheppard01.assetmanager.assetapi.services;

import com.tsheppard01.assetmanager.assetapi.dto.AssetDto;
import com.tsheppard01.assetmanager.assetapi.dto.AssetTypeDto;
import com.tsheppard01.assetmanager.assetapi.repository.AssetRepository;
import com.tsheppard01.assetmanager.assetapi.repository.AssetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AssetTypeService {

  @Autowired
  private AssetTypeRepository assetTypeRepository;

  @Autowired
  private AssetRepository assetRepository;

  public List<AssetTypeDto> getAllAssetTypes() {


    return assetTypeRepository.findAll()
        .stream()
        .map(at ->
            new AssetTypeDto(
                at.getId(),
                at.getName(),
                at.getDescription(),
                at.getAssetCategory().getName()
            )
        ).collect(Collectors.toList());
  }

  public List<AssetDto> getAllAssets() {

    return assetRepository.findAll()
        .stream()
        .map(a ->
            new AssetDto(
                a.getId(),
                a.getSerialNumber(),
                a.getAssetType().getName(),
                a.getAssetType().getDescription(),
                a.getAssetType().getAssetCategory().getName()
            )).collect(Collectors.toList());
  }
}
