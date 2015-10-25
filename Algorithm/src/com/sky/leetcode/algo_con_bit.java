/**
* @author DuanSky
* @date 2015年10月24日 下午1:10:08
* @content 
*/
package com.sky.leetcode;

public class algo_con_bit {

	public static void main(String args[]){
		int a=Integer.MAX_VALUE-133;
		int b=13;
		int k=16;
		int max=Integer.MAX_VALUE;
		System.out.println("        a:"+Integer.toBinaryString(a));
//		System.out.println("clear last K:"+Integer.toBinaryString(clearLastK(a,k)));
//		System.out.println("get high k:"+Integer.toBinaryString(getHighKbit(a,k)));
//		System.out.println("get low k:"+Integer.toBinaryString(getLowKbit(a,k)));
//		switchAB(a,b);
//		System.out.println("count one bit "+Integer.bitCount(a)+":"+count1bitCount(a));
		System.out.println("reverse a:"+Integer.toBinaryString(reverseInt(a)));
	}
	
	public static int clearLastK(int a,int k){
		int flash=0;
		for(int i=0;i<k;i++){
			flash+=(1<<i);
		}
		return a&(0xffffffff-flash);
	}
	
	public static int getHighKbit(int a,int k){
		return a>>>(32-k);
	}
	
	public static int getLowKbit(int a,int k){
		return a<<k;
	}
	
	public static void switchAB(int a,int b){
		System.out.println(a+" "+b);
		a=a^b;
		b=a^b;
		a=a^b;
		System.out.println(a+" "+b);
	}
	
	public static int count1bitCount(int a){
		int result=0;
		while(a!=0){
			result+=(a&1);
			a>>>=1;
		}
		return result;
	}
	
	public static int reverseInt(int a){
		int bit=0;int result=0;
		for(int i=0;i<32;i++){
			bit=a&1;
			result<<=1;
			result+=bit;
			a>>>=1;
		}
		return result;
	}
	
	public static boolean isSymmetry(int a){
		return false;
	}
}
