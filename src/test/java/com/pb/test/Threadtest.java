package com.pb.test;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Threadtest {
	public static void main(String[] args) {
		final outputter ot = new outputter();
		final DataTest dt = new DataTest();
//		new Thread() {
//			public void run() {
//				ot.output("asds");
//			};
//		}.start();
//		
//		new Thread() {
//			public void run() {
//				ot.output("zxcv");
//			}
//		}.start();
		for(int i = 0; i < 3; i++) {
			new Thread() {
				public void run() {
					for(int j = 0; j < 5; j++) {
						dt.set(new Random().nextInt(10));
					}
				}
			}.start();
		}
		for(int i = 0; i < 3; i++) {
			new Thread() {
				public void run() {
					for(int j = 0; j < 5; j++) {
						dt.get();
					}
				}
			}.start();
		}
	}
}


class outputter {
	//������
	private Lock lock = new ReentrantLock();
	public void output(String name) {
		//�����
		lock.lock();
		try {
			for(int i = 0; i < name.length(); i++) {
				System.out.print(name.charAt(i) + "---");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//lock��Ҫ�ֶ��ͷ���
			lock.unlock();
		}
	}
}

/**
 * ��д��---��������ʱ�����������߳�ͬʱ���ʣ�ʹ��д������ʱֻ����һ���߳̽���
 * @author haohan
 *
 */
class DataTest {
	//���������
	private int data;
	//��д��
	private ReadWriteLock lock = new ReentrantReadWriteLock();
	//��ȡ����
	public synchronized int get() {
		lock.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName() + "׼����ȡ����");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "��ȡ����Ϊ" + this.data);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.readLock().unlock();
		}
		return data;
	}
	//д������
	public synchronized int set(int data) {
		lock.writeLock().lock();
		try {
			System.out.println(Thread.currentThread().getName() + "׼��д������");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.data = data;
			System.out.println(Thread.currentThread().getName() + "д������Ϊ" + this.data);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//����
			lock.writeLock().unlock();
		}
		return data;
	}
	
}