package com.tiket.test.senior.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.NoArgsConstructor;

@Document
@NoArgsConstructor
public class Employee{
	
	private long employeeId;
	private String firstName;
	private String lastName;
	private String title;
	private String workPhone;
	
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getWorkPhone() {
		return workPhone;
	}
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	
}
