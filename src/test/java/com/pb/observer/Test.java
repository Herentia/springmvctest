package com.pb.observer;

public class Test {
	
	public static void main(String[] args) {
		//创建观察者
		NameObserver no = new NameObserver();
		PriceObserver po = new PriceObserver();
		//创建被观察者
		Product p = new Product("what", 1.00);
		//在被观察者上面注册观察者
		p.addobs(no);
		p.addobs(po);
		//修改被观察者属性，通知观察者
		p.setName("修改后的我，哈哈");
		p.setPrice(10000.00);
	}

}
