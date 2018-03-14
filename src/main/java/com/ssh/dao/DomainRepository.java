package com.ssh.dao;

import java.io.Serializable;
import java.util.List;

public interface DomainRepository<T, PK extends Serializable> {
	
	//ͨ��Id��ʱ��ȡʵ����
	T load(PK id);
	//ͨ��IDʵʱ��ȡʵ����
	T get(PK id);
	
	List<T> findAll();

    void persist(T entity);

    PK save(T entity);

    void saveOrUpdate(T entity);

    void delete(PK id);

    void flush();

}
