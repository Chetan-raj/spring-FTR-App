package com.infyFTR.exceptions;

public class NoSuchWorkitemException extends Exception {
 
	private static final long serialVersionUID = 1L;
	
 
	

	public NoSuchWorkitemException() {
		super();
	}

	public NoSuchWorkitemException(String errors) {
		super(errors);
		
	}
	
	

}

