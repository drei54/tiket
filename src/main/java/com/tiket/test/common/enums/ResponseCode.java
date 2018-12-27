package com.tiket.test.common.enums;

public enum ResponseCode {
	/*
	 *  SUCCESS 
	 */
	SUCCESS(200),
	/*
	 *  FAILED 
	 *  used if there is any invalid input
	 */
	FAILED(99),
	INTERNAL_SERVER_ERROR(500),
    URL_NOT_FOUND(404),
    QUESTIONS_NOT_FOUND(211),
	NOT_FOUND(401),
	FOUND(405),
	/*
	 *  EXCEPTION 
	 *  used only for unexpected response 
	 */
	EXCEPTION(98);	
	
	private int value = 200;
	
	private ResponseCode(int value) {
		this.value = value;
	}
	
	/*
	 * Setter and Getter
	 */
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}
