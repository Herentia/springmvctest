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
	 * ð�����򷽷�һ
	 * @param n ��Ҫ��������
	 */
	public void methodone(int[] n) {
		int temp;
		for(int i = 0; i < n.length - 1; i++ ) {
			for(int j = 0; j < n.length - 1 - i; j++) {//����λ�����Ƚϣ�С�ķ�ǰ�棬��÷ź���
				//ÿһ�ֿ��ų�������
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
	 * ð�����򷽷���
	 * @param n
	 */
	public void methodtwo(int[] n) {
		int temp;
		for(int i = 0; i < n.length - 1; i++) {
			for(int j = i + 1; j < n.length; j++) {//�ӵ�һλ������ÿһ�����Ƚϣ��������ȵ�һλС��
				//��λ��ÿ���ų���Сλ
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
	 * �۰����
	 */
	public Boolean halfSearch() {
		int data[] = { 12, 16, 19, 22, 24, 25, 32, 39, 39, 48, 55, 57,58,63, 68, 69, 70, 78, 84, 88, 90, 97 };
		int val = 24;//��Ҫ���ҵ���ֵ
		int left = 0;//��߽�Ϊ0
		int right = data.length - 1;//�ұ߽�
		int mid = (left + right) / 2;//��ȡ���е��±�
		while(data[mid] != val) {
			if(val > data[mid]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
			if(left >= right) {
				System.out.println("û���ҵ���Ҫ���ҵ���ֵ");
				return false;
			}
			mid = (left + right) / 2;
		}
		System.out.println("�ҵ���Ҫ���ҵ�����" + data[mid]);
		return true;
	}

}
