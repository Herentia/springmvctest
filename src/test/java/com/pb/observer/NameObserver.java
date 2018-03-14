package com.pb.observer;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 名称观察者，当名称发生改变时接收通知
 * @author haohan
 *
 */
public class NameObserver implements Observer {

	@Override
	public void updata(Observable o, Object args) {
		if(args instanceof String) {
			String name = (String) args;
			JFrame jf = new JFrame("观察者");
			JLabel jl = new JLabel("名称改变为：" + name);
			jf.add(jl);
			jf.pack();
			jf.setVisible(true);
			System.out.println("观察者" + o + "---名称改变为： " + name);
		}
	}

}
