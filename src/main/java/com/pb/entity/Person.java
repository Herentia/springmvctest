package com.pb.entity;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.internal.txw2.annotation.XmlElement;

/**
 * ���Խ����󷵻�Ϊjson��xml
 * @author haohan
 *
 */
@XmlRootElement(name = "person_xml")
public class Person {
	
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	@XmlElement
	public void setAge(int age) {
		this.age = age;
	}
	
}