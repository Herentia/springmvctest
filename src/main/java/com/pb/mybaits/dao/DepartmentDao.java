package com.pb.mybaits.dao;

import com.pb.mybaits.bean.Department;

public interface DepartmentDao {
	
	public Department getDeptById(Integer deptno);
	
	public Department getDeptByIdPlus(Integer deptno);
	//分步式获取dept
	public Department getDeptByIdStep(Integer deptno);
	//通过mybatis内置参数判断获取dept
	public Department getDeptInner(Integer deptno);

}
