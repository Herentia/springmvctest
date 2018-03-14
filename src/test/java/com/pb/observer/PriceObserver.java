package com.pb.observer;

public class PriceObserver implements Observer {

	@Override
	public void updata(Observable o, Object args) {
		if(args instanceof Double) {
			System.out.println("观察者" + o + "---价格改变为：" + args);
		}
	}

}
