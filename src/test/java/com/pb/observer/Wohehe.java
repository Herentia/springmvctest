package com.pb.observer;

import java.util.Observable;
import java.util.Observer;

public class Wohehe implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("��ɶ�Ҷ��ӵ�֪ͨ��" + o + "---" + arg);
	}

}
