package com.tsheppard01.assetmanager.externalapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestSummaryDto {

  public RequestSummaryDto() {}

  private UUID id;

  private String status;

  private LocalDateTime dateTimeCreated;
  
}
