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
	//锁对象
	private Lock lock = new ReentrantLock();
	public void output(String name) {
		//获得锁
		lock.lock();
		try {
			for(int i = 0; i < name.length(); i++) {
				System.out.print(name.charAt(i) + "---");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//lock需要手动释放锁
			lock.unlock();
		}
	}
}

/**
 * 读写锁---读操作锁时可以允许多个线程同时访问，使用写操作锁时只允许一个线程进行
 * @author haohan
 *
 */
class DataTest {
	//共享的数据
	private int data;
	//读写锁
	private ReadWriteLock lock = new ReentrantReadWriteLock();
	//读取数据
	public synchronized int get() {
		lock.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName() + "准备读取数据");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "读取数据为" + this.data);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.readLock().unlock();
		}
		return data;
	}
	//写入数据
	public synchronized int set(int data) {
		lock.writeLock().lock();
		try {
			System.out.println(Thread.currentThread().getName() + "准备写入数据");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.data = data;
			System.out.println(Thread.currentThread().getName() + "写入数据为" + this.data);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//解锁
			lock.writeLock().unlock();
		}
		return data;
	}
	
}