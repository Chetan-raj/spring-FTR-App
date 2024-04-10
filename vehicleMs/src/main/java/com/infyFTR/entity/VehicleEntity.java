package com.infyFTR.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ftr_vehicles")
public class VehicleEntity {
	
	@Id
	@Column(name = "vehicle_number", nullable = false)
	private String vehicleNumber;
	@Column(name = "vehicle_name", nullable = false)
	private String vehicleName;
	@Column(name = "max_lifting_capacity", nullable = false)
	private double maxLiftingCapacity;
	@Column(name = "retire_date", nullable = false)
	private Date retireDate;
	@Column(name = "vehicle_status", nullable = false)
	private String vehicleStatus;
	@Column(name = "harbor_location", nullable = false)
	private String harborLocation;
	@Column(name = "country", nullable = false)
	private String country;
	
	public VehicleEntity() {
		
	}
	
	public VehicleEntity(String vehicleNumber, String vehicleName, double maxLiftingCapacity, Date retireDate,
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

}
