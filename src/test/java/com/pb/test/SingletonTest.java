package com.pb.test;

public class SingletonTest {
	
	public static void main(String[] args) {
		Singleton2 s1 = Singleton2.getInstance();
		Singleton2 s2 = Singleton2.getInstance();
		System.out.println(s1 == s2);
	}

}
/**
 * ����
 * @author haohan
 *
 */
class Singleton {
	private static Singleton instance;
	//Ӱ�ع�����
	private Singleton() {
		super();
	}
	public static Singleton getInstance() {
		if(instance == null) {
			System.out.println("������������");
			instance = new Singleton();
		}
		return instance;
	}
}

/**
 * ����
 * @author haohan
 *
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
 * �ڲ���
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