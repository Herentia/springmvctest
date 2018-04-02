package com.pb.mybaits.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;

import com.pb.mybaits.bean.Hero;

public interface HeroDao {
	
	public Hero getHeroById(int id);
	
	public int addHero(Hero hero);
	
	public void updateHeroById(Hero hero);
	
	public int delHero(int id);
	//����һ��list����
	public List<Hero> getListByCamp(String camp);
	//����һ��map��key���������� ֵ���Ƕ�Ӧ��ֵ
	public Map<String, Object> getHeroByReturnMap(int id);
	//���ض���map��key����������ֵ����ÿ����¼��ֵ
	@MapKey("id")
	public Map<Integer, Hero> getHeroByHeroNameReturnMap(String heroname);

}
