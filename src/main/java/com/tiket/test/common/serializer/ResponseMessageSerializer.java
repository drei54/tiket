package com.tiket.test.common.serializer;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.tiket.test.common.enums.ResponseMessage;
import com.tiket.test.common.properties.PropertiesUtil;

public class ResponseMessageSerializer extends StdSerializer<ResponseMessage> {
	 
    /**
	 * 
	 */
	private static final long serialVersionUID = -693056094060814002L;
	
	@Autowired
	private PropertiesUtil propertiesUtil;
	//public Map<String, String> err = new HashMap<String, String>();

	public ResponseMessageSerializer() {
        this(null);
    }
 
    public ResponseMessageSerializer(Class<ResponseMessage> t) {
        super(t);
    }
    
    public void serialize(ResponseMessage value, JsonGenerator generator, SerializerProvider provider) 
      throws IOException, JsonProcessingException {
        generator.writeStartObject();
        generator.writeFieldName("code");
        generator.writeNumber(value.getCode());
        generator.writeFieldName("key");
        generator.writeString(value.name());
        generator.writeFieldName("field");
        generator.writeString(value.getField());
        generator.writeFieldName("message");
        if(propertiesUtil!=null && value.getValue()!=null){
        	generator.writeString(propertiesUtil.getMessage().get(value.getValue()));
        }else{
        	generator.writeString("");
        }
        generator.writeEndObject();
    }
}