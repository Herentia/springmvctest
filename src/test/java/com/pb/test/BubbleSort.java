package com.pb.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

public class BubbleSort {
	
	public static void main(String[] args) {
//		int n[] = {67, 69, 75, 87, 89, 90, 99, 100};
//		new BubbleSort().halfSearch();
//		long a = 10;
//		int b = 6;
//		int c = (int) (a/b);
//		System.out.println(c);
		LocalDate ld = LocalDate.now();
		System.out.println(ld);
		String today = ld.toString();
		System.out.println(today);
	}
	
	/**
	 * 冒泡排序方法一
	 * @param n 需要排序数组
	 */
	public void methodone(int[] n) {
		int temp;
		for(int i = 0; i < n.length - 1; i++ ) {
			for(int j = 0; j < n.length - 1 - i; j++) {//相邻位两两比较，小的放前面，大得放后面
				//每一轮可排出最大的数
				if(n[j] > n[j + 1]) {
					temp = n[j];
					n[j] = n[j + 1];
					n[j + 1] = temp;
				}
			}
		}
		for(int r : n) {
			System.out.println(r);
		}
	}
	
	/**
	 * 冒泡排序方法二
	 * @param n
	 */
	public void methodtwo(int[] n) {
		int temp;
		for(int i = 0; i < n.length - 1; i++) {
			for(int j = i + 1; j < n.length; j++) {//从第一位与后面的每一个数比较，后面数比第一位小就
				//换位，每轮排出最小位
				if(n[i] > n[j]) {
					temp = n[i];
					n[i] = n[j];
					n[j] = temp;
				}
			}
		}
		for(int r : n) {
			System.out.println(r);
		}
	}
	
	/**
	 * 折半查找
	 */
	public Boolean halfSearch() {
		int data[] = { 12, 16, 19, 22, 24, 25, 32, 39, 39, 48, 55, 57,58,63, 68, 69, 70, 78, 84, 88, 90, 97 };
		int val = 24;//需要查找的数值
		int left = 0;//左边界为0
		int right = data.length - 1;//右边界
		int mid = (left + right) / 2;//获取折中的下标
		while(data[mid] != val) {
			if(val > data[mid]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
			if(left >= right) {
				System.out.println("没有找到需要查找的数值");
				return false;
			}
			mid = (left + right) / 2;
		}
		System.out.println("找到需要查找的数：" + data[mid]);
		return true;
	}

}
