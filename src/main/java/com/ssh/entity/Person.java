package com.ssh.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Person")
public class Person implements Serializable {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "created")
    private Long created = System.currentTimeMillis();

    @Column(name = "username")
    private String username;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "remark")
    private String remark;
    
	public Person() {
		super();
	}
	
	public Person(Integer id, Long created, String username, String address,
			String phone, String remark) {
		super();
		this.id = id;
		this.created = created;
		this.username = username;
		this.address = address;
		this.phone = phone;
		this.remark = remark;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Long getCreated() {
		return created;
	}
	public void setCreated(Long created) {
		this.created = created;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
    
}
