package com.tiket.test.senior.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.NoArgsConstructor;

@Document
@NoArgsConstructor
public class OrderDetail{
	
	private long orderDetailId;
	private Order order;
	private Product product;
	private Integer quantity;
	private Double unitPrice;
	private Double discount;
	

	public long getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(long orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	
}
