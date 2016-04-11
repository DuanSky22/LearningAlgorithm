package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2016年1月4日 下午4:43:51
 * @content 
 */

public class _264_Ugly_Number_II {
	
	public static void main(String args[]){
		System.out.println(_nthUglyNumber(11));
	}
	
	//time limited!
	public static int nthUglyNumber(int n) {
        int counter=0; int i=1;
        while(counter<n){
        	if(isUglyNumber(i++))
        		counter++;
        }
        return i-1;
    }
	
	public static boolean isUglyNumber(int m){
		if(m==1) return true;
		else if(m%2==0) return isUglyNumber(m/2);
		else if(m%3==0) return isUglyNumber(m/3);
		else if(m%5==0) return isUglyNumber(m/5);
		else
			return false;
	}
	
	public static int _nthUglyNumber(int n){
		if(n < 6) return n;
		int t2 = 0, t3 = 0, t5 = 0;
		int uglyNumbers[] = new int[n];
		uglyNumbers[0] = 1;
		for(int i = 1; i < n; i++){
			uglyNumbers[i] = Math.min(uglyNumbers[t5] * 5, 
					Math.min(uglyNumbers[t2] * 2, uglyNumbers[t3] * 3));
			if(uglyNumbers[i]==uglyNumbers[t2] * 2)
				t2++;
			if(uglyNumbers[i]==uglyNumbers[t3] * 3)
				t3++;
			if(uglyNumbers[i]==uglyNumbers[t5] * 5)
				t5++;
		}
		return uglyNumbers[n-1];
	}
	
	public static int power(int a,int b,int c){
		return (int) (Math.pow(2, a)*Math.pow(3, b)*Math.pow(5, c));
	}
}
