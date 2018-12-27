package com.tiket.test.intermediate.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@javax.persistence.Entity
@Table(name = "order_detail")
public class OrderDetail implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5469331343086427621L;
	private long orderDetailId;
	private Order order;
	private Product product;
	private Integer quantity;
	private Double unitPrice;
	private Double discount;
	
	public OrderDetail() {}
	public OrderDetail(long orderDetailId,Order order,Product product,Integer quantity,Double unitPrice,Double discount) {
		this.orderDetailId = orderDetailId;
		this.order = order;
		this.product = product;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.discount = discount;
	}
	
	@Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "order_detail_id", columnDefinition = "INT")
	public long getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(long orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
    @JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Order.class)
	@JoinColumn(name = "order_id", insertable = true, updatable = true, nullable = false)
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Product.class)
	@JoinColumn(name = "product_id", insertable = true, updatable = true, nullable = false)
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Column(name = "quantity", nullable = true, columnDefinition = "INT")
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Column(name = "unit_price", nullable = true, columnDefinition = "DOUBLE")
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	@Column(name = "discount", nullable = true, columnDefinition = "DOUBLE")
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	
}
