package com.pb.test;

public class TestGetClass {
	
	public static void main(String[] args) throws ClassNotFoundException {  
        // TODO Auto-generated method stub  
        TestGetClass t = new TestGetClass(); 
        if(TestGetClass.class == t.getClass())  
        {  
            System.out.println("equal");  
        }  
        System.out.println(t.getClass().getName());  
        System.out.println(t.getClass().getSuperclass());  
    } 

}
