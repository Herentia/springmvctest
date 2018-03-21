package com.ssh.entity;

import java.util.Date;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class Employee {
	
	private Integer id;
	@NotEmpty
	private String lastName;
	@Email
	private String email;
	//1.male 2.female
	private int Gender;
	
	private Department department;
	
	@Past
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birth;
	@NumberFormat(pattern="#,###,###.#")
	private Float salary;
	
	public Employee() {
		super();
	}
	
	public Employee(Integer id, String lastName, String email, int gender,
			Department department) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		Gender = gender;
		this.department = department;
	}

	public Employee(Integer id, String lastName, String email, int gender,
			Department department, Date birth, Float salary) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		Gender = gender;
		this.department = department;
		this.birth = birth;
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getGender() {
		return Gender;
	}

	public void setGender(int gender) {
		Gender = gender;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}
	
}
