package com.pb.test;

public class singletonTest {
	
//    private singletonTest() {  
//    }  
//   
//    private static final singletonTest instance = new singletonTest();  
//   
//    public static singletonTest getInstance() {  
//        return instance;  
//    }
	
	private singletonTest() {}
	
	private static class singletonHolder {
		private static singletonTest instance = new singletonTest();
	}
	
	public static singletonTest getInstance() {
		return singletonHolder.instance;
	}
    
    public static void main(String[] args) {
//		singletonTest s1 = singletonTest.getInstance();
//		singletonTest s2 = singletonTest.getInstance();
//		System.out.println(s1 == s2);
    	String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s1.intern());
	}

}
