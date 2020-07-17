package com.tsheppard01.assetmanager.assetrequest.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "request_item")
public class RequestItem {

  public RequestItem() {}

  public RequestItem(UUID id, UUID assetTypeId, String itemComment) {
    this.id = id;
    this.assetTypeId = assetTypeId;
    this.itemComment = itemComment;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "asset_type_id")
  private UUID assetTypeId;

  @Column(name = "comment")
  private String itemComment;

  @ManyToOne(optional = false)
  @JoinColumn(name = "request_id")
  private Request request;

}
