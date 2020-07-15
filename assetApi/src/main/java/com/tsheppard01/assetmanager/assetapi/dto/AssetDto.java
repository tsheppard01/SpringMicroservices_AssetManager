package com.tsheppard01.assetmanager.assetapi.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class AssetDto {

  public AssetDto(){}

  public AssetDto(UUID id, String serialNumber, String name, String description, String category) {
    this.id = id;
    this.serialNumber = serialNumber;
    this.name = name;
    this.description = description;
    this.category = category;
  }

  private UUID id;

  private String serialNumber;

  private String name;

  private String description;

  private String category;
}
