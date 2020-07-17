package com.tsheppard01.assetmanager.assetrequest.repository;

import com.tsheppard01.assetmanager.assetrequest.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RequestRepository extends JpaRepository<Request, UUID> {
}
