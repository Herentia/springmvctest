package com.pb.observer;

public class PriceObserver implements Observer {

	@Override
	public void updata(Observable o, Object args) {
		if(args instanceof Double) {
			System.out.println("�۲���" + o + "---�۸�ı�Ϊ��" + args);
		}
	}

}
