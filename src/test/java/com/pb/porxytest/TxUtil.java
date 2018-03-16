package com.pb.porxytest;

/**
 * 模拟事务增强处理类
 * @author haohan
 *
 */
public class TxUtil {
	
	void beginTx() {
		System.out.println("开启事务正确处理。。。");
	}
	
	void afterTx() {
		System.out.println("结束时的事务增强处理。。。");
	}

}
