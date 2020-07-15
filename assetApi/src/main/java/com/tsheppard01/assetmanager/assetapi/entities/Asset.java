package com.tsheppard01.assetmanager.assetapi.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "asset")
public class Asset {

  @Id
  @GeneratedValue
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "serial_number", nullable = false)
  private String serialNumber;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "asset_type_id", nullable = false)
  private AssetType assetType;
}
