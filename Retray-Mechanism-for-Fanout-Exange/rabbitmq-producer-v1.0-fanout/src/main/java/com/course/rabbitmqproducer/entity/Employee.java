package com.course.rabbitmqproducer.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {

	@JsonProperty("employee_id")
	private String employeeId;

	private String name;

	@JsonProperty("birth_date")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "Asia/Jakarta")
	private Date birthDate;

	public Employee(String employeeId, String name, Date birthDate) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public String getName() {
		return name;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public void setName(String name) {
		this.name = name;
	}

}
