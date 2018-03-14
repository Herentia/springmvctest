package com.ssh.dao;

import java.io.Serializable;
import java.util.List;

public interface DomainRepository<T, PK extends Serializable> {
	
	//通过Id延时获取实体类
	T load(PK id);
	//通过ID实时获取实体类
	T get(PK id);
	
	List<T> findAll();

    void persist(T entity);

    PK save(T entity);

    void saveOrUpdate(T entity);

    void delete(PK id);

    void flush();

}
