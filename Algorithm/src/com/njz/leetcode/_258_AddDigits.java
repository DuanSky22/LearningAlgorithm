package com.njz.leetcode;


/**
 * digitRoot(数字根)问题，一个数序问题，不需要循环判断每一个位上的数字再做运算，直接利用数序公式
 * digitRoot问题与数字9有关，（10-9）==1==（1+0）；（12-9）==3==（1+2）
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
		 * 考虑到9的整数倍数情况，采用(num-1)/9
		 * 也可以对上述情况单独判断
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
