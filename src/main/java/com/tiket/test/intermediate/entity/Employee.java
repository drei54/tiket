package com.tiket.test.intermediate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@javax.persistence.Entity
@Table(name = "employee")
public class Employee implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5469331343086427621L;
	private long employeeId;
	private String firstName;
	private String lastName;
	private String title;
	private String workPhone;
	
	
	public Employee() {}
	
	public Employee(long employeeId, String firstName, String lastName, String title, String workPhone) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.title =title;
		this.workPhone = workPhone;
	}
	
	@Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "employee_id", columnDefinition = "INT")
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
    @Column(name = "first_name", nullable = true, length = 50)
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
	@Column(name = "title", nullable = true, length = 50)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Column(name = "work_phone", nullable = true, length = 30)
	public String getWorkPhone() {
		return workPhone;
	}
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	
}
