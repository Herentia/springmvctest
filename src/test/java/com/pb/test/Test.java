package com.pb.test;

public class Test {
	
	public static void main(String[] args) {
		new MyThread("�߼�", 10).start();  
        new MyThread("�ͼ�", 1).start(); 
	}
	
}

class MyThread extends Thread {  
    public MyThread(String name,int pro) {  
        super(name);//�����̵߳�����  
        setPriority(pro);//�����̵߳����ȼ�  
    }  
    @Override  
    public void run() {  
        for (int i = 0; i < 100; i++) {  
            System.out.println(this.getName() + "�̵߳�" + i + "��ִ�У�");  
        }  
    }  
} 
