package com.tsheppard01.assetmanager.externalapp.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class AddRequestItemDto {

  private UUID assetTypeId;

  private String comments;

  private UUID requestId;

  private UUID userId;
}
