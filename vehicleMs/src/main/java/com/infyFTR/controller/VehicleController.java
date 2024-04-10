package com.infyFTR.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infyFTR.dto.VehicleDTO;
import com.infyFTR.exceptions.NoSuchVehicleException;
import com.infyFTR.service.VehicleService;

@RestController
@RequestMapping("/vehicles")
@Validated
@CrossOrigin
public class VehicleController implements VehicleControllerInterface{
	
	@Autowired
	private VehicleService vehicleService;
	
	//Adding a vehicle
	@PostMapping(consumes="application/json")
	public ResponseEntity<String> insertNewVehicle(@Valid @RequestBody VehicleDTO dto) throws NoSuchVehicleException
	{
		System.out.println("reaching controller");
		return ResponseEntity.ok(vehicleService.insertNewVehicle(dto));
				
	}
	//Fetch all available Vehicles
	@GetMapping(produces="application/json")
	public  ResponseEntity<List<VehicleDTO>> fetchAvailableVehicles() throws NoSuchVehicleException
	{
		return ResponseEntity.ok(vehicleService.fetchAvailableVehicles());
	}
	//Updating vehicle status
	@PutMapping(value = "/{vehicleNumber}", consumes="application/json")
	public ResponseEntity<String> updateVehicleStatus(@PathVariable("vehicleNumber") 
													@Pattern(regexp="[a-zA-Z]{2}\\d{4}",message= "{vehicle.vehicleNumber.invalid}")
													String vehicleNum, @RequestBody VehicleDTO dto) throws NoSuchVehicleException
	{
		return ResponseEntity.ok(vehicleService.updateVehicleStatus(vehicleNum, dto));
				
	}
	//Fetch Vehicles by vehicleName
//	@GetMapping(value = "/managed-name/{vehicleName}", produces="application/json")
	public  ResponseEntity<List<VehicleDTO>> fetchVehicleDetailsByVehicleName( 
													String vehicleName) throws NoSuchVehicleException
	{
		return ResponseEntity.ok(vehicleService.fetchVehicleDetailsByVehicleName(vehicleName));
	}
	//Fetch Vehicle by vehicleNumber
	@GetMapping(value = "/managed-number/{vehicleNumber}", produces="application/json")
	public  ResponseEntity<VehicleDTO> fetchVehicleDetailsByVehicleNumber(@PathVariable("vehicleNumber")  
												String vehicleNumber) throws NoSuchVehicleException
	{
		return ResponseEntity.ok(vehicleService.fetchVehicleDetailsByVehicleNumber(vehicleNumber));
	}
	//Delete Vehicle by vehicleNumber
	@DeleteMapping(value = "{vehicleNumber}",produces="text/html")
	public ResponseEntity<String> removeVehicle(@PathVariable("vehicleNumber") String vehicleNumber)throws NoSuchVehicleException
	{
		System.out.println("reaching controll");
		return ResponseEntity.ok(vehicleService.removeVehicle(vehicleNumber));
	}

}
