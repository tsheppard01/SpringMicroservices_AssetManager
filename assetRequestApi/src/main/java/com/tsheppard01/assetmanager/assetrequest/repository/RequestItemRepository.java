package com.tsheppard01.assetmanager.assetrequest.repository;

import com.tsheppard01.assetmanager.assetrequest.entities.RequestItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RequestItemRepository extends JpaRepository<RequestItem, UUID> {
}
