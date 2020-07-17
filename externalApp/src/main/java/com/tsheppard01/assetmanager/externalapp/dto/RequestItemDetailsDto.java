package com.tsheppard01.assetmanager.externalapp.dto;

import lombok.Data;

import java.util.List;

@Data
public class RequestItemDetailsDto {

  public RequestItemDetailsDto() {}

  public RequestItemDetailsDto(String name, String category, String comment) {
    this.name = name;
    this.category = category;
    this.comment = comment;
  }

  private String name;

  private String category;

  private String comment;

}
