package com.tiket.test.common.serializer;

import java.io.IOException;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.tiket.test.common.enums.ResponseMessage;
import com.tiket.test.intermediate.controller.FileController;

public class ResponseMessageDeserializer extends StdDeserializer<ResponseMessage> {
	private Logger logger = Logger.getLogger(FileController.class.getName());
    /**
	 * 
	 */
	private static final long serialVersionUID = -693056094060814002L;
	
	//public Map<String, String> err = new HashMap<String, String>();

	public ResponseMessageDeserializer() {
        this(null);
    }
 
    public ResponseMessageDeserializer(Class<ResponseMessage> t) {
        super(t);
    }

	@Override
	public ResponseMessage deserialize(JsonParser jp, DeserializationContext arg1)
			throws IOException, JsonProcessingException {
		logger.info("arg0=>"+jp.getValueAsString());
		
		JsonNode node = jp.getCodec().readTree(jp);
        String key = node.get("key").asText();
        //String itemName = node.get("itemName").asText();
        //int userId = (Integer) ((IntNode) node.get("createdBy")).numberValue();
 
        //return new Item(id, itemName, new User(userId, null));
        
		return ResponseMessage.valueOf(key);
	}
}