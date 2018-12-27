package com.tiket.test.senior.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ShippingMethod{
	
	private long shippingMethodId;
	private String shippingMethod;
	
	public ShippingMethod() {}
	public ShippingMethod(long id, String shippingMethod) {
		this.shippingMethodId = id;
		this.shippingMethod = shippingMethod;
	}
	

	public long getShippingMethodId() {
		return shippingMethodId;
	}
	public void setShippingMethodId(long shippingMethodId) {
		this.shippingMethodId = shippingMethodId;
	}

	public String getShippingMethod() {
		return shippingMethod;
	}
	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}
	
}
