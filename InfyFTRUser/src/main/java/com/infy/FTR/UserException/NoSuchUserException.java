package com.infy.FTR.UserException;
public class NoSuchUserException extends Exception {
	private static final long serialVersionUID = 1L;
	public NoSuchUserException() {
		super();
	}
	public NoSuchUserException(String errors) {
		super(errors);
	}
}
