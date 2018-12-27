package com.tiket.test.common.properties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="wardah")
public class PropertiesUtil {
	//Sample ArrayList
    private List<String> servers = new ArrayList<String>();
    
    
    //Sample String
    private String host = new String();
    
    //Sample Map
    private Map<String, String> users = new HashMap<String, String>();
    
    //Sample Map
    private Map<String, String> activity = new HashMap<String, String>();

    public Map<String, String> getUsers() {
        return this.users;
    }
	
    private Map<String, String> message = new HashMap<String, String>();
	
	
    
    public List<String> getServers() {
        return this.servers;
    }


	public String getHost() {
		return this.host;
	}


	public Map<String, String> getMessage() {
		return message;
	}


	public void setMessage(Map<String, String> message) {
		this.message = message;
	}


	public Map<String, String> getActivity() {
		return activity;
	}


	public void setActivity(Map<String, String> activity) {
		this.activity = activity;
	}


	 
    
}
