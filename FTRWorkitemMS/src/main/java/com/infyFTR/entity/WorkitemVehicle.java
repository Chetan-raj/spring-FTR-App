package com.infyFTR.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.infyFTR.dto.WorkitemVehicleDTO;
@Entity
public class WorkitemVehicle {
	
	private String vehicleNumber;
	@Id
	private String workItemId;
	
	private String assignedWorkItemStatus;
	
	public WorkitemVehicle() {}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getWorkItemId() {
		return workItemId;
	}

	public void setWorkItemId(String workItemId) {
		this.workItemId = workItemId;
	}

	public String getAssignedWorkItemStatus() {
		return assignedWorkItemStatus;
	}

	public void setAssignedWorkItemStatus(String assignedWorkItemStatus) {
		this.assignedWorkItemStatus = assignedWorkItemStatus;
	}
	
	public static WorkitemVehicleDTO prepareWorkitemVehicleDTO(WorkitemVehicle workitemVehicle)
	{
		WorkitemVehicleDTO workitemVehicleDTO = new WorkitemVehicleDTO();
		workitemVehicleDTO.setWorkItemId(workitemVehicle.getWorkItemId());
		workitemVehicleDTO.setVehicleNumber(workitemVehicle.getVehicleNumber());
		workitemVehicleDTO.setAssignedWorkItemStatus(workitemVehicle.getAssignedWorkItemStatus());
		return workitemVehicleDTO;
		
	}
	
}
