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
	//返回一个list集合
	public List<Hero> getListByCamp(String camp);
	//返回一条map：key就是列名， 值就是对应的值
	public Map<String, Object> getHeroByReturnMap(int id);
	//返回多条map：key就是主键，值就是每条记录的值
	@MapKey("id")
	public Map<Integer, Hero> getHeroByHeroNameReturnMap(String heroname);

}
