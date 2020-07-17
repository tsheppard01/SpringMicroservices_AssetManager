package com.tsheppard01.assetmanager.externalapp.dto;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class RequestDetailsDto {

  private RequestDetailsDto() {}

  public RequestDetailsDto(UUID id, String status, LocalDateTime dateTimeCreated, List<RequestItemDetailsDto> items) {
    this.id = id;
    this.status = status;
    this.dateTimeCreated = dateTimeCreated;
    this.items = items;
  }

  private UUID id;

  private String status;

  private LocalDateTime dateTimeCreated;

  @JsonSetter(nulls = Nulls.AS_EMPTY)
  private List<RequestItemDetailsDto> items;
}
