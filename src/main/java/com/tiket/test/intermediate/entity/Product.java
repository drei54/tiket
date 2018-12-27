package com.tiket.test.intermediate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@javax.persistence.Entity
@Table(name = "product")
public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5469331343086427621L;
	private long productId;
	private String productName;
	private Double unitPrice;
	private Integer inStock;
	
	public Product() {}
	public Product(long productId, String productName, Double unitPrice, Integer inStock) {
		this.productId = productId;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.inStock = inStock;
	}
	
	@Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "product_id", columnDefinition = "INT")
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	@Column(name = "product_name", nullable = true, length = 50)
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	@Column(name = "unit_price", nullable = true, columnDefinition = "DOUBLE")
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	@Column(name = "in_stock", nullable = true, columnDefinition = "CHAR")
	public Integer getInStock() {
		return inStock;
	}
	public void setInStock(Integer inStock) {
		this.inStock = inStock;
	}
	
}
