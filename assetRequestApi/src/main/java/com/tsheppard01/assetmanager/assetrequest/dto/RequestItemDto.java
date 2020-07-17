package com.tsheppard01.assetmanager.assetrequest.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class RequestItemDto {

  public RequestItemDto() {}

  public RequestItemDto(UUID assetTypeId, String comment) {
    this.assetTypeId = assetTypeId;
    this.comment = comment;
  }

  public RequestItemDto(UUID id, UUID assetTypeId, String comment) {
    this(assetTypeId, comment);
    this.id = id;
  }

  private UUID id;

  private UUID assetTypeId;

  private String comment;
}
