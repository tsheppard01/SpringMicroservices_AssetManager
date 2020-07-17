package com.tsheppard01.assetmanager.assetrequest.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class RequestItemDto {

  public RequestItemDto(UUID assetTypeId, String comment) {
    this.assetTypeId = assetTypeId;
    this.comment = comment;
  }

  private UUID id;

  private UUID assetTypeId;

  private String comment;
}
