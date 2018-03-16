package com.pb.factorytest;

public class PrintFactory implements OutPutFactory {

	@Override
	public OutPut getOutPut() {
		return new NormalPrint();
	}

}
