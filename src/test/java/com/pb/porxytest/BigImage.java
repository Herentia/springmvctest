package com.pb.porxytest;

public class BigImage implements Image {
	
	public BigImage() {
		super();
		try {
			Thread.sleep(3000);
			System.out.println("ͼƬ���سɹ�������");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void show() {
		System.out.println("���ƴ�ͼƬ����");
	}

}
