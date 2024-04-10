package com.infyFTR.util;
/**
 * The Enum ExceptionConstants.
 */

public enum InfyFTRConstants {

	//Exception message constants
	VEHICLE_NOT_FOUND("vehicle.notFound"),
	VEHICLE_UPDATE_ALREADY_EXISTS("vehicle.update.alreadyExists"),
	GENERAL_EXCEPTION_MESSAGE("general.exception"),
	
	//Success message constants
	VEHICLE_CREATE_SUCCESS("vehicle.create.success"),
	VEHICLE_UPDATE_SUCCESS("vehicle.update.success"),
	VEHICLE_DELETE_SUCCESS("vehicle.delete.success");
	
	
	

	private final String type;

	private InfyFTRConstants(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return this.type;
	}
}
