package com.tsheppard01.assetmanager.assetapi.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class AssetTypeDto {

  public AssetTypeDto() {}

  public AssetTypeDto(UUID id, String name, String description, String category) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.category = category;
  }

  private UUID id;

  private String name;

  private String description;

  private String category;
}
