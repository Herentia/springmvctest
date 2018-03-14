package com.pb.commandtest;

public class CommandTest {
	
	public static void main(String[] args) {
		int[] target = {3, -5, 6, 9};
		ProcessArray processArray = new ProcessArray();
		processArray.each(target, new Command() {
			@Override
			public void process(int[] args) {
				for(int temp : target) {
					System.out.println("��������Ϊ��" + temp);
				}
			}
		});
		System.out.println("----------");
		processArray.each(target, new Command() {
			
			@Override
			public void process(int[] args) {
				int sum = 0;
				for(int temp : target) {
					sum += temp;
				}
				System.out.println("�������������ۺ�Ϊ��" + sum);
			}
		});
	}

}
