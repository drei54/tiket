package com.tiket.test.intermediate.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@javax.persistence.Entity
@Table(name = "`order`")
public class Order implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5469331343086427621L;
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
	
	public Order() {}
	
	public Order(long orderId, Customer customer, Employee employee,Date OrderDate,String purchaseOrderNumber,Date shipDate,ShippingMethod shippingMethod,Integer freightCharge,Integer taxes,Integer paymentReceived,String comment) {
		this.orderId = orderId;
		this.customer = customer;
		this.employee = employee;
		this.OrderDate = OrderDate;
		this.purchaseOrderNumber = purchaseOrderNumber;
		this.shipDate = shipDate;
		this.shippingMethod = shippingMethod;
		this.freightCharge = freightCharge;
		this.taxes = taxes;
		this.paymentReceived = paymentReceived;
		this.comment = comment;
	}
	
	@Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "order_id", columnDefinition = "INT default '13'")
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Customer.class)
	@JoinColumn(name = "customer_id", insertable = true, updatable = true, nullable = false)
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Employee.class)
	@JoinColumn(name = "employee_id", insertable = true, updatable = true, nullable = false)
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Column(name = "order_date", columnDefinition="TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}
	@Column(name = "purchase_order_number", nullable = true, length = 30)
	public String getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}
	public void setPurchaseOrderNumber(String purchaseOrderNumber) {
		this.purchaseOrderNumber = purchaseOrderNumber;
	}
	@Column(name = "ship_date", columnDefinition="TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getShipDate() {
		return shipDate;
	}
	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = ShippingMethod.class)
	@JoinColumn(name = "shipping_method_id", insertable = true, updatable = true, nullable = false)
	public ShippingMethod getShippingMethod() {
		return shippingMethod;
	}
	public void setShippingMethod(ShippingMethod shippingMethod) {
		this.shippingMethod = shippingMethod;
	}
	@Column(name = "freight_charge", columnDefinition = "INT")
	public Integer getFreightCharge() {
		return freightCharge;
	}
	public void setFreightCharge(Integer freightCharge) {
		this.freightCharge = freightCharge;
	}
	@Column(name = "taxes", columnDefinition = "INT")
	public Integer getTaxes() {
		return taxes;
	}
	public void setTaxes(Integer taxes) {
		this.taxes = taxes;
	}
	@Column(name = "paryment_received", nullable = true,  columnDefinition = "INT")
	public Integer getPaymentReceived() {
		return paymentReceived;
	}
	public void setPaymentReceived(Integer paymentReceived) {
		this.paymentReceived = paymentReceived;
	}
	@Column(name = "comment", nullable = true, length = 150)
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Transient
	public List<OrderDetail> getOrderDetails() {
//		List<OrderDetail> list = orderDetailDao.findByOrderId(id);
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Transient
	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	@Transient
	public Double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(Double orderTotal) {
		this.orderTotal = orderTotal;
	}
	
	
}
