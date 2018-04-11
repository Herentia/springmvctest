package com.pb.test;

public class SingletonTest {
	
	public static void main(String[] args) {
		Singleton2 s1 = Singleton2.getInstance();
		Singleton2 s2 = Singleton2.getInstance();
		System.out.println(s1 == s2);
	}

}
/**
 * 懒汉
 * @author haohan
 * 非线程安全，在获取方法上加上synchronized，同步后线程安全
 */
class Singleton {
	private static Singleton instance;
	//影藏构造器
	private Singleton() {
		super();
	}
	public static Singleton getInstance() {
		if(instance == null) {
			System.out.println("创建单例对象");
			instance = new Singleton();
		}
		return instance;
	}
}

/**
 * 饿汉
 * @author haohan
 * 线程安全的
 */
class Singleton1 {

	private Singleton1() {
		super();
	}
	
	private static Singleton1 instance = new Singleton1();
	
	public static Singleton1 getInstance() {
		return instance;
	}
}

/**
 * 双检查锁机制
 * @author haohan
 * 线程安全（推荐）
 */
class MySingleton {
	
	private static volatile MySingleton instance = null;
	
	private MySingleton(){}
	
	public MySingleton getInstance() {
		if(instance == null) {//懒汉模式
			synchronized (MySingleton.class) {
				if(instance == null) {//二次检查
					instance = new MySingleton();
				}
			}
		}
		return instance;
	}
	
}

/**
 * 内部类
 * 线程安全
*/
class Singleton2 {
	private Singleton2() {
		super();
	}
	
	private static class SingletonHodle {
		private static Singleton2 instance = new Singleton2();
	}
	
	public static Singleton2 getInstance() {
		return SingletonHodle.instance;
	}
}