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
	            int min = i;//每一趟循环比较时，min用于存放较小元素的数组下标，这样当前批次比较完毕最终存放的就是此趟内最小的元素的下标，避免每次遇到较小元素都要进行交换。
	            for (int j = i + 1; j < arr.length; j++) {
	                if (arr[j] < arr[min]) {
	                    min = j;
	                }
	            }
	            //进行交换，如果min发生变化，则进行交换
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
