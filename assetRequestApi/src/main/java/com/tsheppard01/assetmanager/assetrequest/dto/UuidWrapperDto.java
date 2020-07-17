package com.tsheppard01.assetmanager.assetrequest.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UuidWrapperDto {

  public UuidWrapperDto() {}

  public UuidWrapperDto(UUID id) {
    this.id = id;
  }

  private UUID id;

}
