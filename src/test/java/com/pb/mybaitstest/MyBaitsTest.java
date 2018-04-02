package com.pb.mybaitstest;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.junit.Test;

import com.pb.mybaits.bean.Hero;
import com.pb.mybaits.dao.HeroDao;

public class MyBaitsTest {
	
	@Test
	public void test() {
		String resource = "mybatis-config.xml";
		//获取sqlSession，能够执行查询语句
		SqlSession session = null; //SqlSession和Connection一样不是线程安全的，每次使用都应该去获取新的
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory =
			  new SqlSessionFactoryBuilder().build(inputStream);
			session = sqlSessionFactory.openSession();
			//可以通过namespace+id名的形式或id（此时id为唯一）的形式作为第一个参数传入
			Hero hero = session.selectOne("selectHero", 1);
			System.out.println(hero);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void getHeroById() {
		String resource = "mybatis-config.xml";
		SqlSession session = null;
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sqlSessionFactory.openSession();
			HeroDao hd = session.getMapper(HeroDao.class);//HeroDao没有实现类，但是mybaits会为这个借口生成一个代理对象
//			Hero hero = hd.getHeroById(1);
//			System.out.println(hero);
			//增加
//			Hero hero = new Hero("符文法师", "德玛西亚", 0, "辅助");
//			hd.addHero(hero);
			//修改
//			Hero hero = new Hero(5, "娑娜", "德玛西亚", 0, "辅助");
//			hd.updateHeroById(hero);
			//删除
//			hd.delHero(5);
			//通过所属名获取hero集合
//			List<Hero> heros = hd.getListByCamp("%亚%");
//			for (Hero hero : heros) {
//				System.out.println(hero);
//			}
			//获取map
//			Map<String, Object> map = hd.getHeroByReturnMap(1);
//			System.out.println(map);
			//获取多个map
			System.out.println(session);
			Map<Integer, Hero> map= hd.getHeroByHeroNameReturnMap("%亚%");
			System.out.println(map);
			session.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}

}
