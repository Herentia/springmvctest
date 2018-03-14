package com.pb.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 被观察者抽象基类，被观察者都应该继承该基类
 * @author haohan
 */
public abstract class Observable {
	
	//用list来保存该对象上的所有事件监听器
	private List<Observer> observers = new ArrayList<Observer>();
	
	//注册观察者
	public void addobs(Observer o) {
		observers.add(o);
	}
	
	//删除观察者
	public void delobs(Observer o) {
		observers.remove(o);
	}
	
	//通知该主题上的所有观察者
	public void notifyObserver(Object val) {
		for(Iterator it = observers.iterator(); it.hasNext(); ) {
			Observer obs = (Observer) it.next();
			//显示每个观察者的update方法
			obs.updata(this, val);
		}
	}

}
