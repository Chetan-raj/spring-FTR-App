package com.infyFTR.dto;

import com.infyFTR.entity.WorkitemVehicle;

public class WorkitemVehicleDTO {
	
	private String vehicleNumber;
	private String workItemId;
	
	private String assignedWorkItemStatus;
	
	public WorkitemVehicleDTO() {}

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
	
	public static WorkitemVehicle prepareWorkitemVehicleEnity(WorkitemVehicleDTO workitemVehicleDTO)
	{
		WorkitemVehicle workitemVehicle = new WorkitemVehicle();
		workitemVehicle.setWorkItemId(workitemVehicleDTO.getWorkItemId());
		workitemVehicle.setVehicleNumber(workitemVehicleDTO.getVehicleNumber());
		workitemVehicle.setAssignedWorkItemStatus(workitemVehicleDTO.getAssignedWorkItemStatus());
		return workitemVehicle;
		
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
