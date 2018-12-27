package com.tiket.test.common.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tiket.test.common.serializer.ResponseMessageDeserializer;
import com.tiket.test.common.serializer.ResponseMessageSerializer;

/**
 * enums for response message 
 * this enum will be integrated with application properties
 * @see <i>message.properties</i> in resource
 * 
 * 
 * 
 * @author zeger
 *
 */
@JsonSerialize(using = ResponseMessageSerializer.class)
@JsonDeserialize(using = ResponseMessageDeserializer.class)
public enum ResponseMessage {
	ACK_APP_001(1,"ack.app.001");
	
	private String value = "";
	private String field = "";
	private int code = 0;
		
	private ResponseMessage(int code,String value) {
		this.value = value;
		this.code = code;
	}
	
	/*
	 * Setter and Getter
	 */
	@JsonValue
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
}
