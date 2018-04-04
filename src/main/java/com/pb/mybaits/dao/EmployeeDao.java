package com.pb.mybaits.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pb.mybaits.bean.Employee;


public interface EmployeeDao {
	
	public void addEmp(Employee emp);
	
	public Employee getEmpAndDept(Integer empno);
	
	public Employee getEmpByIdStep(Integer empno);
	
	//通过部门id查询所有员工
	public List<Employee> getEmpsById(Integer deptno);
	//一次通过foreach传入多个参数
	public List<Employee> getEmpForEach(@Param("ids") List<Integer> aa);
	//批量保存
	public void addEmps(@Param("emps") List<Employee> emps);
	
}
