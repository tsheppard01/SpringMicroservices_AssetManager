package com.tsheppard01.assetmanager.assetrequest.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class AssetRequestItemDto {

  private UUID id;

  private UUID assetTypeId;

  private String comments;

}
