package com.pb.observer;

public class Test {
	
	public static void main(String[] args) {
		//�����۲���
		NameObserver no = new NameObserver();
		PriceObserver po = new PriceObserver();
		//�������۲���
		Product p = new Product("what", 1.00);
		//�ڱ��۲�������ע��۲���
		p.addobs(no);
		p.addobs(po);
		//�޸ı��۲������ԣ�֪ͨ�۲���
		p.setName("�޸ĺ���ң�����");
		p.setPrice(10000.00);
	}

}
