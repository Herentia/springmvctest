package com.pb.mybaits.bean;

import org.apache.ibatis.type.Alias;

@Alias("hero")//±ðÃû
public class Hero {
	
	private Integer id;
	private String heroName;
	private String camp;
	private int sex;
	private String professiontype;
	
	public Hero() {
		super();
	}
	
	public Hero(String heroName, String camp, int sex, String professiontype) {
		super();
		this.heroName = heroName;
		this.camp = camp;
		this.sex = sex;
		this.professiontype = professiontype;
	}

	public Hero(Integer id, String heroName, String camp, int sex,
			String professiontype) {
		super();
		this.id = id;
		this.heroName = heroName;
		this.camp = camp;
		this.sex = sex;
		this.professiontype = professiontype;
	}

	public long getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHeroName() {
		return heroName;
	}
	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}
	public String getCamp() {
		return camp;
	}
	public void setCamp(String camp) {
		this.camp = camp;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getProfessiontype() {
		return professiontype;
	}
	public void setProfessiontype(String professiontype) {
		this.professiontype = professiontype;
	}
	@Override
	public String toString() {
		return "Hero [id=" + id + ", heroName=" + heroName + ", camp=" + camp
				+ ", sex=" + sex + ", professiontype=" + professiontype + "]";
	}
	
}
