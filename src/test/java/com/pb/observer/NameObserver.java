package com.pb.observer;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * ���ƹ۲��ߣ������Ʒ����ı�ʱ����֪ͨ
 * @author haohan
 *
 */
public class NameObserver implements Observer {

	@Override
	public void updata(Observable o, Object args) {
		if(args instanceof String) {
			String name = (String) args;
			JFrame jf = new JFrame("�۲���");
			JLabel jl = new JLabel("���Ƹı�Ϊ��" + name);
			jf.add(jl);
			jf.pack();
			jf.setVisible(true);
			System.out.println("�۲���" + o + "---���Ƹı�Ϊ�� " + name);
		}
	}

}
