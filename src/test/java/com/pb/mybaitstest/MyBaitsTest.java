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
		//��ȡsqlSession���ܹ�ִ�в�ѯ���
		SqlSession session = null; //SqlSession��Connectionһ�������̰߳�ȫ�ģ�ÿ��ʹ�ö�Ӧ��ȥ��ȡ�µ�
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory =
			  new SqlSessionFactoryBuilder().build(inputStream);
			session = sqlSessionFactory.openSession();
			//����ͨ��namespace+id������ʽ��id����ʱidΪΨһ������ʽ��Ϊ��һ����������
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
			HeroDao hd = session.getMapper(HeroDao.class);//HeroDaoû��ʵ���࣬����mybaits��Ϊ����������һ���������
//			Hero hero = hd.getHeroById(1);
//			System.out.println(hero);
			//����
//			Hero hero = new Hero("���ķ�ʦ", "��������", 0, "����");
//			hd.addHero(hero);
			//�޸�
//			Hero hero = new Hero(5, "���", "��������", 0, "����");
//			hd.updateHeroById(hero);
			//ɾ��
//			hd.delHero(5);
			//ͨ����������ȡhero����
//			List<Hero> heros = hd.getListByCamp("%��%");
//			for (Hero hero : heros) {
//				System.out.println(hero);
//			}
			//��ȡmap
//			Map<String, Object> map = hd.getHeroByReturnMap(1);
//			System.out.println(map);
			//��ȡ���map
			System.out.println(session);
			Map<Integer, Hero> map= hd.getHeroByHeroNameReturnMap("%��%");
			System.out.println(map);
			session.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}

}
