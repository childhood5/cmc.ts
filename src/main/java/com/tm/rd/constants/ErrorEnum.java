package com.tm.rd.constants;

/**
 * List of all errors
 * 
 * @author tong
 */
public enum ErrorEnum {

	INVALID_ID("400", "Invalid Id");

	private String code;
	
	private String message;

	/**
	 * Initial constructor of ErrorEnum
	 * 
	 * @param code
	 * @param message
	 */
	ErrorEnum(final String code, final String message) {
		this.code = code;
		this.message = message;
	}

	// Get code
	public String getCode() {
		return code;
	}

	// Set code
	public void setCode(String code) {
		this.code = code;
	}

	// Get message
	public String getMessage() {
		return message;
	}

	// Set message
	public void setMessage(String message) {
		this.message = message;
	}
}
