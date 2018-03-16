package com.pb.factorytest;

public class OutFactoryFactory {
	
	public static OutPutFactory getOutFactory(String type) {
		if(type.equals("better")) 
			return new BetterFactory();
		else
			return new PrintFactory();
	}

}
