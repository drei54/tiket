package com.tiket.test.senior.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.NoArgsConstructor;

@Document
@NoArgsConstructor
public class Product{
	
	private long productId;
	private String productName;
	private Double unitPrice;
	private Integer inStock;
	

	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getInStock() {
		return inStock;
	}
	public void setInStock(Integer inStock) {
		this.inStock = inStock;
	}
	
}
