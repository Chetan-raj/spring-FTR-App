package com.infyFTR.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.infyFTR.dto.VehicleDTO;
import com.infyFTR.exceptions.NoSuchVehicleException;

public interface VehicleControllerInterface {

	@GetMapping(value = "/managed-name/{vehicleName}", produces="application/json")
	public  ResponseEntity<List<VehicleDTO>> fetchVehicleDetailsByVehicleName(@PathVariable("vehicleName")  
													String vehicleName) throws NoSuchVehicleException;
}
