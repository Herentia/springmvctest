package com.pb.test;

public class Test {
	
	public static void main(String[] args) {
		new MyThread("高级", 10).start();  
        new MyThread("低级", 1).start(); 
	}
	
}

class MyThread extends Thread {  
    public MyThread(String name,int pro) {  
        super(name);//设置线程的名称  
        setPriority(pro);//设置线程的优先级  
    }  
    @Override  
    public void run() {  
        for (int i = 0; i < 100; i++) {  
            System.out.println(this.getName() + "线程第" + i + "次执行！");  
        }  
    }  
} 
