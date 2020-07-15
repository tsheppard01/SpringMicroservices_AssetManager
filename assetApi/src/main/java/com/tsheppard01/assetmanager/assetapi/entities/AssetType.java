package com.tsheppard01.assetmanager.assetapi.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "asset_type")
public class AssetType {

  @Id
  @GeneratedValue
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "description", nullable = false)
  private String description;

  @JoinColumn(name = "asset_category_id", nullable = false)
  @ManyToOne(cascade = CascadeType.ALL)
  private AssetCategory assetCategory;
}
