package com.pb.factorytest;

public class BetterFactory implements OutPutFactory {

	@Override
	public OutPut getOutPut() {
		return new BetterPrint();
	}

}
