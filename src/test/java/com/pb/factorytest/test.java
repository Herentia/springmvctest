package com.pb.factorytest;

public class test {
	
	public static void main(String[] args) {
		OutPutFactory opf = OutFactoryFactory.getOutFactory("hah");
		OutPut op = opf.getOutPut();
		op.PrintIt();
	}

}
