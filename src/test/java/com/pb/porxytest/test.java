package com.pb.porxytest;

public class test {
	
	public static void main(String[] args) {
//		Image i = new BigImage();
//		i.show();
		System.out.println(System.currentTimeMillis());
		Image i = new ImagePorxy(null);
		System.out.println("创建对象" + System.currentTimeMillis());
		i.show();
	}

}
