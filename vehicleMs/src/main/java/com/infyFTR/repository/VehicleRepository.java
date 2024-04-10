package com.infyFTR.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infyFTR.entity.VehicleEntity;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, String> {
	
	List<VehicleEntity> findByVehicleName(String vehicle_name);
}
