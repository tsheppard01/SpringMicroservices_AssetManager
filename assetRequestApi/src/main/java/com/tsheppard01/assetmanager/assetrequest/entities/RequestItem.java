package com.tsheppard01.assetmanager.assetrequest.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "request_item")
public class RequestItem {

  public RequestItem() {}

  public RequestItem(UUID assetTypeId, String comment, Request request) {
    this.assetTypeId = assetTypeId;
    this.comment = comment;
    this.request = request;
  }

  public RequestItem(UUID id, UUID assetTypeId, String comment) {
    this.id = id;
    this.assetTypeId = assetTypeId;
    this.comment = comment;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "asset_type_id")
  private UUID assetTypeId;

  @Column(name = "comment")
  private String comment;

  @ManyToOne(optional = false)
  @JoinColumn(name = "request_id")
  private Request request;

}
