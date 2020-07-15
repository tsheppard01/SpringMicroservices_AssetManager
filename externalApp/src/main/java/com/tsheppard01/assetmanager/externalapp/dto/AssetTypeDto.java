package com.tsheppard01.assetmanager.externalapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.UUID;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssetTypeDto {

  public AssetTypeDto() {}

  private UUID id;

  private String name;

  private String description;

  private String category;
}
