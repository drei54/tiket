package com.tiket.test.senior.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.NoArgsConstructor;

@Document
@NoArgsConstructor
public class Order{
	
	private long orderId;
	private Customer customer;
	private Employee employee;
	private Date OrderDate;
	private String purchaseOrderNumber;
	private Date shipDate;
	private ShippingMethod shippingMethod;
	private Integer freightCharge;
	private Integer taxes;
	private Integer paymentReceived;
	private String comment;
	private List<OrderDetail> orderDetails;
	private Double subTotal;
	private Double orderTotal;
	

	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}

	public String getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}
	public void setPurchaseOrderNumber(String purchaseOrderNumber) {
		this.purchaseOrderNumber = purchaseOrderNumber;
	}

	public Date getShipDate() {
		return shipDate;
	}
	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}

	public ShippingMethod getShippingMethod() {
		return shippingMethod;
	}
	public void setShippingMethod(ShippingMethod shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public Integer getFreightCharge() {
		return freightCharge;
	}
	public void setFreightCharge(Integer freightCharge) {
		this.freightCharge = freightCharge;
	}

	public Integer getTaxes() {
		return taxes;
	}
	public void setTaxes(Integer taxes) {
		this.taxes = taxes;
	}

	public Integer getPaymentReceived() {
		return paymentReceived;
	}
	public void setPaymentReceived(Integer paymentReceived) {
		this.paymentReceived = paymentReceived;
	}

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(Double orderTotal) {
		this.orderTotal = orderTotal;
	}
}
