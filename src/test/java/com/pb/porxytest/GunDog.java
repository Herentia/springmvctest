package com.pb.porxytest;

public class GunDog implements Dog {

	@Override
	public void info() {
		System.out.println("我是一只猎狗！！！");
	}

	@Override
	public void run() {
		System.out.println("我正在飞速奔跑！！！");
	}

}
