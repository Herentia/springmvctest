package com.ssh.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ssh.entity.Department;

@Repository
public class DepartmentDao {
	
	private static Map<Integer, Department> departments = null;
	
	static {
		departments = new HashMap<Integer, Department>();
		departments.put(101, new Department(101, "AA"));
		departments.put(102, new Department(102, "BB"));
		departments.put(103, new Department(103, "CC"));
		departments.put(104, new Department(104, "DD"));
		departments.put(105, new Department(105, "EE"));
	}
	
	public Collection<Department> getDepartments() {
		return departments.values();
	}
	
	public Department getDepartment(Integer id) {
		return departments.get(id);
	}

}
