package com.pb.porxytest;

public class BigImage implements Image {
	
	public BigImage() {
		super();
		try {
			Thread.sleep(3000);
			System.out.println("图片加载成功。。。");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void show() {
		System.out.println("绘制大图片！！");
	}

}
