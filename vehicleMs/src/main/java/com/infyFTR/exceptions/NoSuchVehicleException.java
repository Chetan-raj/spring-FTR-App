package com.infyFTR.exceptions;

public class NoSuchVehicleException extends Exception {
 
	private static final long serialVersionUID = 1L;
	
 
	

	public NoSuchVehicleException() {
		super();
	}

	public NoSuchVehicleException(String errors) {
		super(errors);
		
	}
	
	

}

