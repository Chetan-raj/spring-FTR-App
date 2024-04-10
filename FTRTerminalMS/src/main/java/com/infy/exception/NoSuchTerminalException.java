package com.infy.exception;

public class NoSuchTerminalException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public NoSuchTerminalException()
	{
		super();
	}
	
	public NoSuchTerminalException(String errors)
	{
		super(errors);
	}

}
