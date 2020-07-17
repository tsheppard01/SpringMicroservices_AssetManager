package com.tsheppard01.assetmanager.externalapp.dto;

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
