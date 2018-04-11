package com.pb.mybaits.bean;

import java.io.Serializable;

public class Employee implements Serializable {
	
	private Integer empno;
	private String ename;
	private String job;
	private int mgr;
	private Department department;
	
	public Employee() {
		super();
	}
	
	public Employee(Integer empno, String ename, String job, int mgr,
			Department department) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.department = department;
	}

	public Integer getEmpno() {
		return empno;
	}
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + ", job=" + job
				+ ", mgr=" + mgr + ", department=" + department + "]";
	}
	
}
