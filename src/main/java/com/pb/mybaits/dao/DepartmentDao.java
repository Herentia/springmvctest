package com.pb.mybaits.dao;

import com.pb.mybaits.bean.Department;

public interface DepartmentDao {
	
	public Department getDeptById(Integer deptno);
	
	public Department getDeptByIdPlus(Integer deptno);
	//�ֲ�ʽ��ȡdept
	public Department getDeptByIdStep(Integer deptno);
	//ͨ��mybatis���ò����жϻ�ȡdept
	public Department getDeptInner(Integer deptno);

}
