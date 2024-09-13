package com.company.management.custom.exception;

import org.springframework.stereotype.Component;

@Component
public class EmptyInputException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String description;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public EmptyInputException(String errorCode, String description) {
		super();
		this.errorCode = errorCode;
		this.description = description;
	} 
	public EmptyInputException ()
	{
		
	}
	
}
