package com.tiket.test.intermediate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id", "shippingMethod"})
@JsonInclude(Include.NON_NULL)
@javax.persistence.Entity
@Table(name = "shipping_method")
public class ShippingMethod implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5469331343086427621L;
	private long shippingMethodId;
	private String shippingMethod;
	
	public ShippingMethod() {}
	
	public ShippingMethod(long shippingMethodId, String shippingMethod) {
		this.shippingMethodId = shippingMethodId;
		this.shippingMethod = shippingMethod;
	}
	
	@Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "shipping_method_id", columnDefinition = "INT")
	public long getShippingMethodId() {
		return shippingMethodId;
	}
	public void setShippingMethodId(long shippingMethodId) {
		this.shippingMethodId = shippingMethodId;
	}
	@Column(name = "shipping_method", nullable = true, length = 20)
	public String getShippingMethod() {
		return shippingMethod;
	}
	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}
	
}
