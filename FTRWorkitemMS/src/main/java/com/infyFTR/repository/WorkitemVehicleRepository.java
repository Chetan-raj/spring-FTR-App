package com.infyFTR.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infyFTR.entity.WorkitemVehicle;
@Repository
public interface WorkitemVehicleRepository extends JpaRepository<WorkitemVehicle,String> {
	List<WorkitemVehicle> findByVehicleNumber(String vehicleNumber);

}
