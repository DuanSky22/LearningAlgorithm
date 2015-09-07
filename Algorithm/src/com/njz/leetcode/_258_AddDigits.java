package com.njz.leetcode;


/**
 * digitRoot(���ָ�)���⣬һ���������⣬����Ҫѭ���ж�ÿһ��λ�ϵ������������㣬ֱ����������ʽ
 * digitRoot����������9�йأ���10-9��==1==��1+0������12-9��==3==��1+2��
 * 23-(23/9)*9 = 5 = (2+3)
 * @author Andy
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it. 
 */
public class _258_AddDigits {

	public static int addDigits(int num) {
		if(num < 0)
			return 0;
		
//		int count_9 = num / 9;
//		return num - 9*count_9;
		/*
		 * ���ǵ�9�������������������(num-1)/9
		 * Ҳ���Զ�������������ж�
		 */
		int count_9 = (num-1) / 9;
		return num - 9*count_9;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int test = -3;
		System.out.println("test : " + addDigits(test));
	}

}
