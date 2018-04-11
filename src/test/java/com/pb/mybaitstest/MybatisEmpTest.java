package com.pb.mybaitstest;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javafx.scene.DepthTest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.pb.mybaits.bean.Department;
import com.pb.mybaits.bean.Employee;
import com.pb.mybaits.bean.Hero;
import com.pb.mybaits.dao.DepartmentDao;
import com.pb.mybaits.dao.EmployeeDao;
import com.pb.mybaits.dao.HeroDao;

public class MybatisEmpTest {
	
	@Test
	public void getEmpById() {
		String resource = "mybatis-config.xml";
		SqlSession session = null;
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			System.out.println(inputStream);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sqlSessionFactory.openSession();
			EmployeeDao ed = session.getMapper(EmployeeDao.class);//HeroDaoû��ʵ���࣬����mybaits��Ϊ����������һ���������
//			Employee employee =  ed.getEmpAndDept(7499);
//			System.out.println(employee + "---" + employee.getDepartment());
//			Employee employee = ed.getEmpByIdStep(7499);
//			System.out.println(employee.getEname());
			List<Employee> emps = ed.getEmpForEach(Arrays.asList(1, 2, 3));
			for (Employee employee : emps) {
				System.out.println(employee);
			}
			
//			List<Employee> emps = new ArrayList<Employee>();
//			emps.add(new Employee(1, "jay", "musicman", 8888, new Department(10)));
//			emps.add(new Employee(2, "jion", "musicgril", 8888, new Department(10)));
//			emps.add(new Employee(3, "lihong", "musicman", 8888, new Department(10)));
//			ed.addEmps(emps);
//			Employee emp = new Employee(1, "jay", "musicman", 8888, new Department(10));
//			ed.addEmp(emp);
			session.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void getDept() {
		String resource = "mybatis-config.xml";
		SqlSession session = null;
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			System.out.println(inputStream);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sqlSessionFactory.openSession();
			DepartmentDao dd = session.getMapper(DepartmentDao.class);
			//��ѯdept��������
//			Department dept = dd.getDeptByIdPlus(10);
			//�ֲ�ʽͨ�����Ż�ȡ�ò����µ�Ա��
//			Department dept = dd.getDeptByIdStep(10);
//			System.out.println(dept.getDname());
//			System.out.println(dept.getEmployees());
			//ʹ��mybatis���õĲ���_parameter��_databaseId�������жϲ�ѯ
			Department dept = dd.getDeptInner(10);
			Department dept2 = dd.getDeptInner(10);
			System.out.println(dept.getDname());
			System.out.println(dept2.getDname());
			session.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
