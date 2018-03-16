package com.pb.porxytest;

public class InvokationHandlerTest {
	
	public static void main(String[] args) {
		Dog dog = new GunDog();
		dog.info();
		dog.run();
		MyInvokationHandler mih = new MyInvokationHandler(dog);
//		mih.setTarget(dog);
		Dog d = (Dog) mih.getProxy();
		System.out.println(d);
		d.info();
		d.run();
	}

}
