package com.pb.porxytest;

public class ImagePorxy implements Image {
	
	//��Ҫ������Ķ���
	private Image image;
	
	public ImagePorxy(Image image) {
		super();
		this.image = image;
	}

	@Override
	public void show() {
		if(image == null) {
			image = new BigImage();
		}
		image.show();
	}

}
