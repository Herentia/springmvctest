package com.pb.observer;

/**
 * 具体被观察者类产品，里面包含名称和价格属性
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
	//当产品名称发生改变时通知观察者
	public void setName(String name) {
		this.name = name;
		notifyObserver(name);
	}
	public double getPrice() {
		return price;
	}
	//当产品价格发生改变时通知观察者
	public void setPrice(double price) {
		this.price = price;
		notifyObserver(price);
	}
	
}
