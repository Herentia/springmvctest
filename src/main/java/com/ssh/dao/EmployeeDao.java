package com.ssh.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssh.entity.Department;
import com.ssh.entity.Employee;

@Repository
public class EmployeeDao {
	
	private static Map<Integer, Employee> employees = null;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	static {
		employees = new HashMap<Integer, Employee>();
		employees.put(1001, new Employee(1001, "e-aa", "aa@163.com", 1, new Department(101, "AA")));
		employees.put(1002, new Employee(1002, "e-bb", "bb@163.com", 1, new Department(102, "BB")));
		employees.put(1003, new Employee(1003, "e-cc", "cc@163.com", 0, new Department(103, "CC")));
		employees.put(1004, new Employee(1004, "e-dd", "dd@163.com", 1, new Department(104, "DD")));
		employees.put(1005, new Employee(1005, "e-ee", "ee@163.com", 0, new Department(105, "EE")));
	}
	
	private static Integer initId = 1006;
	public void save(Employee employee) {
		if(employee.getId() == null) {
			employee.setId(initId++);
		}
		employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
		employees.put(employee.getId(), employee);
	}
	
	public Collection<Employee> getAll(){
		return employees.values();
	}
	
	public Employee get(Integer id){
		return employees.get(id);
	}
	
	public void delete(Integer id){
		employees.remove(id);
	}

}
