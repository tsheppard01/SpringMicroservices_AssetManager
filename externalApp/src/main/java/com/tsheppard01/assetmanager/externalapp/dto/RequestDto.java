package com.tsheppard01.assetmanager.externalapp.dto;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class RequestDto {

  public RequestDto() {}

  private UUID id;

  private String status;

  private LocalDateTime dateTimeCreated;

  @JsonSetter(nulls = Nulls.AS_EMPTY)
  private List<RequestItemDto> items = new ArrayList<>();

}
