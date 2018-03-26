package com.ssh.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssh.dao.DepartmentDao;
import com.ssh.dao.EmployeeDao;
import com.ssh.entity.Employee;

@Controller
public class EmployeeHandler {
	@Autowired
	private DepartmentDao departmentDao;
	@Autowired
	private EmployeeDao employeeDao;
	
	//显示employee
	@RequestMapping("/emps")
	public String list(Map<String, Object> map) {
		map.put("employees", employeeDao.getAll());
		return "list";
	}
	
	//跳转到增加员工页面,
	@RequestMapping(value="/emp", method=RequestMethod.GET)
	public String input(Map<String, Object> map) {
		map.put("departments", departmentDao.getDepartments());
		map.put("employee", new Employee());
		return "input";
	}
	//增加员工也可以用BindingResult来接收错误，BindingResult继承Errors
	@RequestMapping(value="/emp", method=RequestMethod.POST)
	public String add(@Valid Employee employee, Errors errors, Map<String, Object> map) {
		System.out.println("save    " + employee.getDepartment().getDepartmentname() + "---" + employee.getDepartment().getId());
		if(errors.getErrorCount() > 0){
			System.out.println("出错了!");
			for(FieldError error : errors.getFieldErrors()){
				System.out.println(error.getField() + ":" + error.getDefaultMessage());
			}
			//若验证出错, 则转向定制的页面
			map.put("departments", departmentDao.getDepartments());
			return "input";
		}
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
	//删除一条记录
	@RequestMapping(value="/emp/{id}", method=RequestMethod.DELETE)
	public String del(@PathVariable Integer id) {
		employeeDao.delete(id);
		return "redirect:/emps";
	}
	
	//修改，跳转到修改页面
	@RequestMapping(value="/emp/{id}", method=RequestMethod.GET)
	public String input(@PathVariable Integer id, Map<String, Object> map) {
		map.put("departments", departmentDao.getDepartments());
		map.put("employee", employeeDao.get(id));
		return "input";
	}
	//修改
	@RequestMapping(value="/emp", method=RequestMethod.PUT)
	public String update(Employee employee) {
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
	@ModelAttribute
	public void getEmployee(@RequestParam(value="id", required=false) Integer id,
			Map<String, Object> map) {
		if(id != null) {
			map.put("employee", employeeDao.get(id));
		}
	}
	
	@RequestMapping("testConversionServiceConver")
	public String testConverter(@RequestParam("employee") Employee employee) {
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	

}
