package com.tsheppard01.assetmanager.assetapi.repository;

import com.tsheppard01.assetmanager.assetapi.entities.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AssetRepository extends JpaRepository<Asset, UUID> {
}
