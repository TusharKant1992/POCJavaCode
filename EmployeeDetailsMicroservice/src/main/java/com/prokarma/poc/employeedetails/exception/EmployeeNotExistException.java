package com.prokarma.poc.employeedetails.exception;

public class EmployeeNotExistException extends RuntimeException {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	public EmployeeNotExistException() {
		super();
	}

	public EmployeeNotExistException(String message) {
		super(message);
	}
}
