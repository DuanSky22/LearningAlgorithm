package com.njz.leetcode;

/*
 * 2的幂特点�?? �??2�??0次方1，左移位得到的，�??�??
 * powerOftwo的二进制编码中只有一�??1，仅有首位为1，其余各位都�??0.
 * 利用这个性质就可以判断了
 * 
 * 
 * 8�??   前置 0
	10�??  不需前置
	16�??  前置 0x 或�?? 0X 
 */
public class _231_PowerofTwo {

	//方法1
	public static boolean isPowerOfTwo(int n){
		if( (n>0) && ( (n&(n-1))==0 ) ) 
			return true;
		return false;
	}
	
	//方法2
	public static boolean isPowerOfTwo1(int n){
		int count_1 = 0;
		while(n > 0){
			if((n & 0x1) == 1)
				count_1++;
			n = n >> 1;
		}
		if(count_1 == 1)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 8;
		System.out.println("test : " + isPowerOfTwo(n));
		System.out.println("test : " + isPowerOfTwo1(n));
		System.out.println(Integer.toBinaryString(n));
	}

}
