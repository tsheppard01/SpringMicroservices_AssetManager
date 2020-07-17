package com.tsheppard01.assetmanager.externalapp.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class RequestItemDto {

  public RequestItemDto() {}

  private UUID assetTypeId;

  private String comment;
}
