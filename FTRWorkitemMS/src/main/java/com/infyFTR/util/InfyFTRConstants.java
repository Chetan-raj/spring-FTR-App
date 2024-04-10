package com.infyFTR.util;
/**
 * The Enum ExceptionConstants.
 */

public enum InfyFTRConstants {
	
	
	//Exception message constants
		WORKITEM_NOT_FOUND("workitem.notFound"),
		HARBOR_NOT_FOUND("harbor.notFound"),
		INPUT_PARAMETER_MISSING("input.parameter.missing"),
		INPUT_DATE_INVALID("input.date.invalid"),
		WORKITEM_ASSIGN_FAIL("workitem.assign.fail"),
		TERMINAL_NOTAVAILABLE("terminal.notAvailable"),
		WORKITEM_TERMINAL_ALLOCATED("workitem.terminal.allocated"),
		WORKITEM_SHIPPINGDATE_FUTURE("workitem.shippingDate.future"),
		GENERAL_EXCEPTION_MESSAGE("general.exception"),
		
		//Success message constants
		WORKITEM_UPDATE_SUCCESS("vehicle.update.success"),
		WORKITEM_ASSIGNED_WITHVEHICLE("workitem.assigned.withVehicle"),
		WORKITEM_FOUND("workitem.found"),
		WORKITEM_VEHICLE_ALLOCATED("workitem.vehicle.allocated "),
		VEHICLE_NOTFOUND("vehicle.notFound"), VEHICLE_ALLOCATED_SUCCESS("vehicle.allocated.success");
		
		
	

	private final String type;

	private InfyFTRConstants(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return this.type;
	}
}
