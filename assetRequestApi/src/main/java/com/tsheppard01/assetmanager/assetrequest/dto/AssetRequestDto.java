package com.tsheppard01.assetmanager.assetrequest.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class AssetRequestDto {

  private UUID id;

  private UUID userId;

  private String status;

  private List<AssetRequestItemDto> items;
}
