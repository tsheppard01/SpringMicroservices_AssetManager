package com.tsheppard01.assetmanager.assetrequest.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class RequestDto {

  public RequestDto() {}

  public RequestDto(UUID id, UUID userId, String status, LocalDateTime dateTimeCreated,List<RequestItemDto> items) {
    this.id = id;
    this.userId = userId;
    this.status = status;
    this.dateTimeCreated = dateTimeCreated;
    this.items = items;
  }

  private UUID id;

  private UUID userId;

  private String status;

  private LocalDateTime dateTimeCreated;

  private List<RequestItemDto> items;
}
