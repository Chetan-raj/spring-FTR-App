package com.infyFTR.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.infyFTR.dto.VehicleDTO;
import com.infyFTR.entity.VehicleEntity;
import com.infyFTR.exceptions.NoSuchVehicleException;
import com.infyFTR.repository.VehicleRepository;
import com.infyFTR.util.InfyFTRConstants;

@Service
@PropertySource("classpath:messages.properties")
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;
	@Autowired
	private Environment environment;
	
	public String insertNewVehicle(VehicleDTO vehicleDTO)
	{
		vehicleRepository.saveAndFlush(vehicleDTO.createEntity());
		String str = environment.getProperty(InfyFTRConstants.VEHICLE_CREATE_SUCCESS.toString());
		String vId = vehicleDTO.getVehicleNumber();
		return str+vId;
	}
	
	public  List<VehicleDTO> fetchAvailableVehicles() throws NoSuchVehicleException
	{
		List<VehicleEntity> vehicleEntities = vehicleRepository.findAll();
		if(vehicleEntities.size()==0) {
			throw new NoSuchVehicleException(environment.getProperty(InfyFTRConstants.VEHICLE_NOT_FOUND.toString()));
		}
		List<VehicleDTO> vehicleDTOs = new ArrayList<>();
		for(VehicleEntity vehicle : vehicleEntities) {
			vehicleDTOs.add(VehicleDTO.valueOf(vehicle));
		}
		return vehicleDTOs;
		//return customerDTOs.stream().map(c->{c.setPassword("*");return c;}).collect(Collectors.toList());
	}
	
	public String updateVehicleStatus(String vehicleNum, VehicleDTO dto) throws NoSuchVehicleException
	{
		Optional <VehicleEntity> vehicle = vehicleRepository.findById(vehicleNum);
		if(vehicle.isPresent())
		{
			VehicleEntity vehicleEntity = vehicleRepository.getById(vehicleNum);
			if(dto.getVehicleStatus().equals(vehicleEntity.getVehicleStatus()))
			{
				throw new NoSuchVehicleException(environment.getProperty(InfyFTRConstants.VEHICLE_UPDATE_ALREADY_EXISTS.toString())+dto.getVehicleStatus());
			}
			vehicleEntity.setVehicleStatus(dto.getVehicleStatus());
			vehicleRepository.saveAndFlush(vehicleEntity);
			String str = environment.getProperty(InfyFTRConstants.VEHICLE_UPDATE_SUCCESS.toString());
			String vId = dto.getVehicleStatus();
			return str+vId;
		}
		else
		{
			throw new NoSuchVehicleException(environment.getProperty(InfyFTRConstants.VEHICLE_NOT_FOUND.toString()));
		}	
	}
	public  List<VehicleDTO> fetchVehicleDetailsByVehicleName(String vehicleName) throws NoSuchVehicleException
	{
		List<VehicleEntity> vehicleEntities = vehicleRepository.findByVehicleName(vehicleName);
		if(vehicleEntities.size()==0)
		{
			throw new NoSuchVehicleException(environment.getProperty(InfyFTRConstants.VEHICLE_NOT_FOUND.toString()));
		}
		List<VehicleDTO> vehicleDTOs = new ArrayList<>();
		for(VehicleEntity vehicle : vehicleEntities) {
			vehicleDTOs.add(VehicleDTO.valueOf(vehicle));
		}
		return vehicleDTOs;
	}
	
	public  VehicleDTO fetchVehicleDetailsByVehicleNumber(String vehicleNumber) throws NoSuchVehicleException
	{
		Optional <VehicleEntity> vehicle = vehicleRepository.findById(vehicleNumber);
		if(vehicle.isPresent())
		{
			VehicleEntity vehicleEntity = vehicleRepository.getById(vehicleNumber);
			VehicleDTO dto = VehicleDTO.valueOf(vehicleEntity);
			return dto;
		}
		else
		{
			throw new NoSuchVehicleException(environment.getProperty(InfyFTRConstants.VEHICLE_NOT_FOUND.toString()));
		}
	}
	public String removeVehicle(String vehicleNumber) throws NoSuchVehicleException
	{
		System.out.println("reaching service");
		Optional <VehicleEntity> vehicle = vehicleRepository.findById(vehicleNumber);
		if(vehicle.isPresent())
		{
			VehicleEntity vehicleEntity = vehicleRepository.getById(vehicleNumber);
			vehicleRepository.delete(vehicleEntity);
			return environment.getProperty(InfyFTRConstants.VEHICLE_DELETE_SUCCESS.toString());
		}
		else
		{
			throw new NoSuchVehicleException(environment.getProperty(InfyFTRConstants.VEHICLE_NOT_FOUND.toString()));
		}
	}
	
	
}
