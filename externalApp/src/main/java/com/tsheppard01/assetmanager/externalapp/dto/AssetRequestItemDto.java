package com.tsheppard01.assetmanager.externalapp.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class AssetRequestItemDto {

  public AssetRequestItemDto(UUID id, UUID assetTypeId, String comments) {
    this.id = id;
    this.assetTypeId = assetTypeId;
    this.comments = comments;
  }

  private UUID id;

  private UUID assetTypeId;

  private String comments;
}
