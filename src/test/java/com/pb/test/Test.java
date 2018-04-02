package com.pb.test;

public class Test {
	
	public static void main(String[] args) {
//		new MyThread("�߼�", 10).start();  
//        new MyThread("�ͼ�", 1).start(); 
		Counter c = new Counter();
		new Thread(new Runnable() {
			@Override
			public void run() {
//				Counter c = new Counter();
				c.add(2);
				System.out.println(c.getCount());
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
//				Counter c = new Counter();
				c.add(3);
				System.out.println(c.getCount());
			}
		}).start();
	}
	
}

class MyThread extends Thread {  
    public MyThread(String name, int pro) {  
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

class Counter {
	private long count = 0;
	public synchronized void add(long value) {
		this.count = this.count + value;
	}
	public long getCount() {
		return count;
	}
}
