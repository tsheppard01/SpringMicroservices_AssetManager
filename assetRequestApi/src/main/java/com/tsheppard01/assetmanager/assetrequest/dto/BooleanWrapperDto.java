package com.tsheppard01.assetmanager.assetrequest.dto;

import lombok.Data;

@Data
public class BooleanWrapperDto {

  public BooleanWrapperDto() {}

  public BooleanWrapperDto(boolean value) {
    this.value = value;
  }

  private boolean value;
}
