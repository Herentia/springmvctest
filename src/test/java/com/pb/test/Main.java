package com.pb.test;

import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) {
		int[] nums = {12, 32, 11, 45, 66, 88, 1, 5};
		
		for(int i = 0; i < nums.length - 1; i ++) {
			for(int j = 0; j < nums.length - 1 - i; j++) {
				if(nums[j] > nums[j + 1]) {
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(nums));
//		selectSort(nums);
	}
	
	 public static void selectSort(int[] arr) {
	        for (int i = 0; i < arr.length - 1; i++) {
	            int min = i;//ÿһ��ѭ���Ƚ�ʱ��min���ڴ�Ž�СԪ�ص������±꣬������ǰ���αȽ�������մ�ŵľ��Ǵ�������С��Ԫ�ص��±꣬����ÿ��������СԪ�ض�Ҫ���н�����
	            for (int j = i + 1; j < arr.length; j++) {
	                if (arr[j] < arr[min]) {
	                    min = j;
	                }
	            }
	            //���н��������min�����仯������н���
	            if (min != i) {
	                swap(arr,min,i);
	            }
	        }
	        System.out.println(Arrays.toString(arr));
	    } 
	 
	 public static void swap(int []arr,int a,int b){
	        arr[a] = arr[a]+arr[b];
	        arr[b] = arr[a]-arr[b];
	        arr[a] = arr[a]-arr[b];
	    }

}
