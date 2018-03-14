package com.pb.observer;

/**
 * 观察者接口
 * @author haohan
 */
public interface Observer {
	//Observable 被观察者  
	void updata(Observable o, Object args);

}
