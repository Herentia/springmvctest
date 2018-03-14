package com.pb.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ���۲��߳�����࣬���۲��߶�Ӧ�ü̳иû���
 * @author haohan
 */
public abstract class Observable {
	
	//��list������ö����ϵ������¼�������
	private List<Observer> observers = new ArrayList<Observer>();
	
	//ע��۲���
	public void addobs(Observer o) {
		observers.add(o);
	}
	
	//ɾ���۲���
	public void delobs(Observer o) {
		observers.remove(o);
	}
	
	//֪ͨ�������ϵ����й۲���
	public void notifyObserver(Object val) {
		for(Iterator it = observers.iterator(); it.hasNext(); ) {
			Observer obs = (Observer) it.next();
			//��ʾÿ���۲��ߵ�update����
			obs.updata(this, val);
		}
	}

}
