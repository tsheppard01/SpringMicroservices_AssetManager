package com.tsheppard01.assetmanager.assetrequest.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class RequestSummaryDto {

  public RequestSummaryDto() {}

  public RequestSummaryDto(UUID id, UUID userId, String status, LocalDateTime dateTimeCreated) {
    this.id = id;
    this.userId = userId;
    this.status = status;
    this.dateTimeCreated = dateTimeCreated;
  }

  private UUID id;

  private UUID userId;

  private String status;

  private LocalDateTime dateTimeCreated;
}
