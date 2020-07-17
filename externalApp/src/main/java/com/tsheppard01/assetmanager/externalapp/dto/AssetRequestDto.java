package com.tsheppard01.assetmanager.externalapp.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class AssetRequestDto {

  public AssetRequestDto(UUID id, UUID userId, String status, List<AssetRequestItemDto> items) {
    this.id = id;
    this.userId = userId;
    this.status = status;
    this.items = items;
  }

  private UUID id;

  private UUID userId;

  private String status;

  private List<AssetRequestItemDto> items;
}
