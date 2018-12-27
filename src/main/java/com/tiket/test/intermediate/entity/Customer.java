package com.tiket.test.intermediate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
@Builder
@JsonInclude(Include.NON_NULL)
@javax.persistence.Entity
@Table(name = "customer")
public class Customer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5469331343086427621L;
	private long customerId;
	private String companyName;
	private String firstName;
	private String lastName;
	private String billingAddress;
	private String city;
	private String stateOrProvince;
	private String zipCode;
	private String email;
	private String companyWebsite;
	private String phoneNumber;
	private String faxNumber;
	private String shipAddress;
	private String shipCity;
	private String shipStateOrProvince;
	private String shipZipCode;
	private String shipPhoneNumber;
	
	public Customer() {}
	
	public Customer(long customerId, String companyName, String firstName, String lastName, String billingAddress, String city, String stateOrProvince, String zipCode, 
			String email, String companyWebsite, String phoneNumber, String faxNumber, String shipAddress, String shipCity, String shipStateOrProvince,
			String shipZipCode, String shipPhoneNumber) {
		this.customerId = customerId;
		this.companyName = companyName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.billingAddress = billingAddress;
		this.city = city;
		this.stateOrProvince = stateOrProvince;
		this.zipCode = zipCode;
		this.email = email;
		this.companyWebsite = companyWebsite;
		this.phoneNumber = phoneNumber;
		this.faxNumber = faxNumber;
		this.shipAddress = shipAddress;
		this.shipCity = shipCity;
		this.shipStateOrProvince = shipStateOrProvince;
		this.shipZipCode = shipZipCode;
		this.shipPhoneNumber = shipPhoneNumber;
		
	}
	
	@Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "customer_id", columnDefinition = "INT")
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	@Column(name = "company_name", nullable = true, length = 50)
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@Column(name = "first_name", nullable = true, length = 30)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Column(name = "last_name", nullable = true, length = 50)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Column(name = "billing_address", nullable = true, length = 255)
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	@Column(name = "city", nullable = true, length = 50)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(name = "state_or_province", nullable = true, length = 20)
	public String getStateOrProvince() {
		return stateOrProvince;
	}
	public void setStateOrProvince(String stateOrProvince) {
		this.stateOrProvince = stateOrProvince;
	}
	@Column(name = "zip_code", nullable = true, length = 20)
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	@Column(name = "email", nullable = true, length = 75)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "company_website", nullable = true, length = 200)
	public String getCompanyWebsite() {
		return companyWebsite;
	}
	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}
	@Column(name = "phone_number", nullable = true, length = 30)
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Column(name = "fax_number", nullable = true, length = 30)
	public String getFaxNumber() {
		return faxNumber;
	}
	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}
	@Column(name = "ship_address", nullable = true, length = 255)
	public String getShipAddress() {
		return shipAddress;
	}
	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}
	@Column(name = "ship_city", nullable = true, length = 50)
	public String getShipCity() {
		return shipCity;
	}
	public void setShipCity(String shipCity) {
		this.shipCity = shipCity;
	}
	@Column(name = "ship_state_or_province", nullable = true, length = 50)
	public String getShipStateOrProvince() {
		return shipStateOrProvince;
	}
	public void setShipStateOrProvince(String shipStateOrProvince) {
		this.shipStateOrProvince = shipStateOrProvince;
	}
	@Column(name = "ship_zip_code", nullable = true, length = 20)
	public String getShipZipCode() {
		return shipZipCode;
	}
	public void setShipZipCode(String shipZipCode) {
		this.shipZipCode = shipZipCode;
	}
	@Column(name = "ship_phone_number", nullable = true, length = 30)
	public String getShipPhoneNumber() {
		return shipPhoneNumber;
	}
	public void setShipPhoneNumber(String shipPhoneNumber) {
		this.shipPhoneNumber = shipPhoneNumber;
	}
	
	
}
