package com.infyFTR.dto;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.infyFTR.entity.VehicleEntity;    

public class VehicleDTO {
	
	@NotEmpty(message="{vehicle.vehicleNumber.must}")
	@Pattern(regexp="[a-zA-Z]{2}\\d{4}",message= "{vehicle.vehicleNumber.invalid}")
	private String vehicleNumber;
	@NotEmpty(message="{vehicle.vehicleName.must}")
	@Size(min = 3, max = 30, message="{vehicle.vehicleName.invalid}")
	@Pattern(regexp="(Tower crane|FirePlace Crane|Double treadwheel Crane|Crawler Crane|Aerial Crane|Deck Crane)",message= "{vehicle.vehicleName.invalid}")
	private String vehicleName;
	@NotNull(message="{vehicle.maxLiftingCapacity.must}")
	//@Pattern(regexp="([0-9]+.?)+",message= "{vehicle.maxLiftingCapacity.invalid}")
	private double maxLiftingCapacity;
	//@NotEmpty(message="{vehicle.retireDate.must}")
	//@JsonFormat(pattern = "dd-MMM-yyyy") "2021-11-25"
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date retireDate;
	@NotEmpty(message="{vehicle.vehicleStatus.must}")
	@Pattern(regexp="Active|Retired|InProgress",message= "{vehicle.vehicleStatus.invalid}")
	private String vehicleStatus;
	@NotEmpty(message="{vehicle.harborLocation.must}")
	@Size(min = 5, max = 25, message="{vehicle.harborLocation.invalid}")
	private String harborLocation;
	@NotEmpty(message="{vehicle.country.must}")
	@Size(min = 5, max = 25, message="{vehicle.country.invalid}")
	private String country;
	
	public VehicleDTO() {
		
	}
	
	public VehicleDTO(String vehicleNumber, String vehicleName, double maxLiftingCapacity, Date retireDate,
			String vehicleStatus, String harborLocation, String country) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.vehicleName = vehicleName;
		this.maxLiftingCapacity = maxLiftingCapacity;
		this.retireDate = retireDate;
		this.vehicleStatus = vehicleStatus;
		this.harborLocation = harborLocation;
		this.country = country;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public double getMaxLiftingCapacity() {
		return maxLiftingCapacity;
	}

	public void setMaxLiftingCapacity(double maxLiftingCapacity) {
		this.maxLiftingCapacity = maxLiftingCapacity;
	}

	public Date getRetireDate() {
		return retireDate;
	}

	public void setRetireDate(Date retireDate) {
		this.retireDate = retireDate;
	}

	public String getVehicleStatus() {
		return vehicleStatus;
	}

	public void setVehicleStatus(String vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}

	public String getHarborLocation() {
		return harborLocation;
	}

	public void setHarborLocation(String harborLocation) {
		this.harborLocation = harborLocation;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	// Converts DTO into Entity
		public VehicleEntity createEntity() 
		{
			VehicleEntity ve = new VehicleEntity();
			ve.setVehicleNumber(this.getVehicleNumber());
			ve.setVehicleName(this.getVehicleName());
			ve.setMaxLiftingCapacity(this.getMaxLiftingCapacity());
			ve.setRetireDate(this.getRetireDate());
			ve.setVehicleStatus(this.getVehicleStatus());
			ve.setHarborLocation(this.getHarborLocation());
			ve.setCountry(this.getCountry());
				
			return ve;
		}
		// Converts Entity into DTO
		public static VehicleDTO valueOf(VehicleEntity vehicle) 
		{
			VehicleDTO vehicleDTO= new VehicleDTO();
			vehicleDTO.setVehicleNumber(vehicle.getVehicleNumber());
			vehicleDTO.setVehicleName(vehicle.getVehicleName());
			vehicleDTO.setMaxLiftingCapacity(vehicle.getMaxLiftingCapacity());
			vehicleDTO.setRetireDate(vehicle.getRetireDate());
			vehicleDTO.setVehicleStatus(vehicle.getVehicleStatus());
			vehicleDTO.setHarborLocation(vehicle.getHarborLocation());
			vehicleDTO.setCountry(vehicle.getCountry());

			return vehicleDTO;
		} 
}
