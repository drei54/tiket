package com.tiket.test.common.response;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tiket.test.common.enums.ResponseCode;
import com.tiket.test.common.enums.ResponseMessage;
import com.tiket.test.intermediate.controller.FileController;

@JsonInclude(Include.NON_NULL)
public class GenericResponse implements Serializable{
	private Logger logger = Logger.getLogger(FileController.class.getName());
	//private static final Logger log = LogManager.getLogger(GenericResponse.class);
    /**
	 * 
	 */
	private static final long serialVersionUID = -5560351027550549940L;
	private Object data;
	private Object error;
	private PaginationResponse pagination;

	private Object message;
	private List<ResponseMessage> responseMessage;

	private ResponseCode status;
	
	public GenericResponse(){}
    
    public GenericResponse(Object data, ResponseCode status){
        this.data = data;
        this.status = status;
    }
    
    public GenericResponse(List<ResponseMessage> responseMessage, ResponseCode status){
        this.responseMessage = responseMessage;
        this.status = status;
    }
    
    public GenericResponse(ResponseCode status){
        this.status = status;
    }
    
    /**
     * get the class object convert from json response
     * @param className
     * @return className
     */
    @JsonIgnore
    public <T>T getData(Class<T> className){
    	if(data instanceof JSONObject){
    		try{
    			ObjectMapper mapper = new ObjectMapper();
    			Object obj = mapper.readValue(data.toString(), className);
	    		//Gson gson = new GsonBuilder().create();
	    		//JsonObject yourMap = (JsonObject)getData();
	    		//Object obj = gson.fromJson(yourMap, className);
	    		
	    		return className.cast(obj);
    		}catch (StackOverflowError e) {
    			logger.info("className do not match with json object");
			} catch (JsonParseException e) {
				logger.info("className do not match with json object");
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				logger.info("className do not match with json object");
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				logger.info("className do not match with json object");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	try {
			return className.newInstance();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	return null;
    }
    

    /**
     * get the class object convert from json response
     * @param className
     * @return className
     */
    @JsonIgnore
    public <T>List<T> getList(Class<T[]> className){
    	if(data instanceof JSONArray){
    		try{
    			ObjectMapper mapper = new ObjectMapper();
    			T[] arr = mapper.readValue(data.toString(), className);
	    		//T[] arr = gson.fromJson(yourMap, className);
	    		return Arrays.asList(arr);
	    	}catch (StackOverflowError e) {
	    		logger.info("className do not match with json array object");
    			return new ArrayList<T>();
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.info("className do not match with json array object");
    			return new ArrayList<T>();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.info("className do not match with json array object");
    			return new ArrayList<T>();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.info("className do not match with json array object");
    			return new ArrayList<T>();
			}
    	}
    	return new ArrayList<T>();
    }
    
    public GenericResponse(Page<?> data, ResponseCode status){
        this.data = data.getContent();
        this.pagination = new PaginationResponse();
        this.pagination.setFirst(data.isFirst());
        this.pagination.setLast(data.isLast());
        this.pagination.setNumber(data.getNumber());
        this.pagination.setNumberOfElements(data.getNumberOfElements());
        this.pagination.setSize(data.getSize());
        this.pagination.setSort(data.getSort());
        this.pagination.setTotalElements(data.getTotalElements());
        this.pagination.setTotalPages(data.getTotalPages());
        
        this.status = status;
    }
    
    public GenericResponse(String message,ResponseCode status){
    	
        this.message = message;
        this.status = status;
    }

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	public Object getError() {
		return error;
	}

	public void setError(Object error) {
		this.error = error;
	}

	public Object getMessage() {
		return message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}

	public ResponseCode getStatus() {
		return status;
	}

	public void setStatus(ResponseCode status) {
		this.status = status;
	}
	
	public int getCode(){
		return this.status.getValue();
	}
	
	public void setCode(int code){
		//return this.status.getValue();
	}

	public PaginationResponse getPagination() {
		return pagination;
	}

	public void setPagination(PaginationResponse pagination) {
		this.pagination = pagination;
	}

	public List<ResponseMessage> getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(List<ResponseMessage> responseMessage) {
		this.responseMessage = responseMessage;
	}

	public void addResponseMessage(ResponseMessage responseMessage) {
		if(this.responseMessage==null){
			this.responseMessage = new ArrayList<ResponseMessage>();
		}
		this.responseMessage.add(responseMessage);
	}
}
