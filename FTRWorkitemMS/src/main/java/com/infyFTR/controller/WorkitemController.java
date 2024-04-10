package com.infyFTR.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infyFTR.dto.ErrorMessage;
import com.infyFTR.dto.TerminalDTO;
import com.infyFTR.dto.VehicleDTO;
import com.infyFTR.dto.WorkitemDTO;
import com.infyFTR.dto.WorkitemVehicleDTO;
import com.infyFTR.exceptions.NoSuchWorkitemException;
import com.infyFTR.service.WorkitemService;

@RestController
@RequestMapping("/workitems")
@Validated
public class WorkitemController {
	@Autowired
	private WorkitemService workitemService;
	
	
	@PostMapping(consumes ="Application/json")
	public ResponseEntity createWorkitem(@Valid @RequestBody WorkitemDTO workitemDTO,Errors errors)
	{
		
		String response = "";
		
		if (errors.hasErrors())
		{
			response = errors.getAllErrors().stream().map(ObjectError::getDefaultMessage)
					.collect(Collectors.joining(","));
			ErrorMessage error = new ErrorMessage();
			error.setErrorCode(HttpStatus.NOT_ACCEPTABLE.value());
			error.setMessage(response);
			return org.springframework.http.ResponseEntity.ok(error);
		}
		else {
		 
		return org.springframework.http.ResponseEntity.ok(workitemService.createWorkitem(workitemDTO));
		}
	}
	
	
	@GetMapping(value="/managed-status/{workitemId}")
	public ResponseEntity<WorkitemVehicleDTO> fetchWorkItemStatus(@PathVariable("workitemId") String workitemId)
	{
		return org.springframework.http.ResponseEntity.ok(workitemService.fetchWorkItemStatus(workitemId));
	}
	
	@GetMapping
	public ResponseEntity<List<WorkitemDTO>> fetchFTRWorkitemDetails() throws NoSuchWorkitemException
	{
		
		return org.springframework.http.ResponseEntity.ok(workitemService.fetchWorkItemDetails());
	
	}
	@GetMapping(value="/managed-status/{userId}")
	public 	ResponseEntity<List<WorkitemDTO>> trackWorkitemByUser(@PathVariable("userId")long userId) throws NoSuchWorkitemException
	{
		return org.springframework.http.ResponseEntity.ok(workitemService.trackWorkitemByUser(userId));
	}
	
	@PostMapping(value="/managed-status/{workitemId}",consumes ="Application/json")
	public ResponseEntity<String> allocateVehicle(@PathVariable("workitemId") String workitemId,@RequestBody String vehicleNumber)
	{
		return org.springframework.http.ResponseEntity.ok(workitemService.allocateVehicle(workitemId, vehicleNumber));
	}
	@GetMapping(value="/{sourceCountry}")
	public ResponseEntity<List<String>> fetchAvailableHarborLocations(@PathVariable("sourceCountry") String country)
	{
		return org.springframework.http.ResponseEntity.ok(workitemService.fetchAvailableHarborLocations(country));
	}
	
	@PutMapping("/{workitemId}")
	public ResponseEntity<String> updateWorkItem (@PathVariable("workitemId") String workitemId,@Valid @RequestBody WorkitemDTO workitemDTO) throws NoSuchWorkitemException{
		return ResponseEntity.ok(workitemService.updateWorkItem(workitemId, workitemDTO));
	}
	//@PutMapping("/{workitemId}")
	//public ResponseEntity<String> updateWorkItemStatus(@PathVariable("workitemId") String workitemId)throws NoSuchWorkitemException{
		
		//return ResponseEntity.ok(workitemService.updateWorkItemStatus("workeitemId"));
	//}
	@GetMapping("/managed-vehicle/{vehicleNumber}")
	public ResponseEntity<WorkitemVehicleDTO> fetchWorkitemDetailsByVehicleNumber(@PathVariable("vehicleNumber") String vehicleNumber) throws NoSuchWorkitemException{
		return ResponseEntity.ok(workitemService.fetchWorkitemDetailsByVehicleNumber(vehicleNumber));
	}
	@PostMapping("/managed-terminal/{workitemId}")
	public ResponseEntity<String> assignTerminalForWorkitem (@PathVariable("workitemId") String workitemId) throws NoSuchWorkitemException{
		return ResponseEntity.ok( workitemService.assignTerminalForWorkitem(workitemId));
	}
	@PostMapping("/managed-vehicle/{workitemId}")
	public ResponseEntity<String> allocateVehicle(@PathVariable("workitemId") String workitemId,@RequestBody List<VehicleDTO> vehicleDtoList) throws NoSuchWorkitemException{
		return ResponseEntity.ok(workitemService.allocateVehicle(workitemId, vehicleDtoList));
	}
	@PutMapping("workItems/managed-update/{workitemId}")
	ResponseEntity<String> updateWorkItemStatus(@PathVariable String workitemId,@RequestBody TerminalDTO terminalDTO) throws NoSuchWorkitemException{
		return ResponseEntity.ok(workitemService.updateWorkItemStatus(workitemId,terminalDTO));
	}
	
	
}
