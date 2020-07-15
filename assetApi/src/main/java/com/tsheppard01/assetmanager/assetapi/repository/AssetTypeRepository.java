package com.tsheppard01.assetmanager.assetapi.repository;

import com.tsheppard01.assetmanager.assetapi.entities.AssetType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AssetTypeRepository extends JpaRepository<AssetType, UUID> {
}
