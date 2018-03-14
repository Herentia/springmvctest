package com.pb.observer;

/**
 * ���屻�۲������Ʒ������������ƺͼ۸�����
 * @author haohan
 *
 */
public class Product extends Observable {
	
	private String name;
	private double price;
	
	public Product() {
		super();
	}
	public Product(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	//����Ʒ���Ʒ����ı�ʱ֪ͨ�۲���
	public void setName(String name) {
		this.name = name;
		notifyObserver(name);
	}
	public double getPrice() {
		return price;
	}
	//����Ʒ�۸����ı�ʱ֪ͨ�۲���
	public void setPrice(double price) {
		this.price = price;
		notifyObserver(price);
	}
	
}
