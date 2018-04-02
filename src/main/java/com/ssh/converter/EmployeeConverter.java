package com.ssh.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ssh.dao.DepartmentDao;
import com.ssh.entity.Department;
import com.ssh.entity.Employee;

@Component
public class EmployeeConverter implements Converter<String, Employee> {
	
	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public Employee convert(String source) {
		if(source != null) {
			String[] vals = source.split("-");
			if(vals != null && vals.length == 4) {
				String lastname = vals[0];
				String email = vals[1];
				Integer gender = Integer.parseInt(vals[2]);
				Department department = departmentDao.getDepartment(Integer.parseInt(vals[3]));
				Employee e = new Employee(null, lastname, email, gender, department);
				System.out.println(source + "---converter---" + e);
				return e;
			}
		}
		return null;
	}

}
