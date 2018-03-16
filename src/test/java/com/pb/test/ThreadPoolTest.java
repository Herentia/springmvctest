package com.pb.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
	
	public static void main(String[] args) {
//		ExecutorService pool = Executors.newSingleThreadExecutor();
//		ExecutorService pool = Executors.newFixedThreadPool(3);
		ExecutorService pool = Executors.newCachedThreadPool();
		for(int i = 0; i < 5; i++) {
			final int taskId = i;
			pool.execute(new Runnable() {
				public void run() {
					for(int i = 0; i < 5; i++) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("第" + taskId + "次任务" + ", 第" + i + "次执行");
					}
				}
			});
		}
	}

}
