package com.pb.commandtest;

public class ProcessArray {
	
	//定义一个each用于处理数组
	public void each(int[] args, Command cmd) {
		cmd.process(args);
	}

}
