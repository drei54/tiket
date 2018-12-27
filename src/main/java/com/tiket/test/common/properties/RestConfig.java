package com.tiket.test.common.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestProperties;

//@Configuration
public class RestConfig extends RepositoryRestProperties {

	@Value("${spring.data.rest.default-page-size}")
	private String size;

	@Override
    
    public Integer getDefaultPageSize() {
    	// TODO Auto-generated method stub
    	super.setDefaultPageSize(Integer.parseInt(size));
    	return super.getDefaultPageSize();
    }

}