package com.pb.mybaits.bean;

import java.util.List;

public class Department {
	
	private Integer deptno;
	private String dname;
	
	private List<Employee> employees;
	
	public Department() {
		super();
	}
	
	public Department(Integer deptno) {
		super();
		this.deptno = deptno;
	}

	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", dname=" + dname
				+ ", employees=" + employees + "]";
	}
	
}
