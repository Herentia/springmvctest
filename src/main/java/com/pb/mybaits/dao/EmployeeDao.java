package com.pb.mybaits.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pb.mybaits.bean.Employee;


public interface EmployeeDao {
	
	public void addEmp(Employee emp);
	
	public Employee getEmpAndDept(Integer empno);
	
	public Employee getEmpByIdStep(Integer empno);
	
	//ͨ������id��ѯ����Ա��
	public List<Employee> getEmpsById(Integer deptno);
	//һ��ͨ��foreach����������
	public List<Employee> getEmpForEach(@Param("ids") List<Integer> aa);
	//��������
	public void addEmps(@Param("emps") List<Employee> emps);
	
}
