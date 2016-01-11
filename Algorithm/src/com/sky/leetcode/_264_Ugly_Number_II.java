package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2016年1月4日 下午4:43:51
 * @content 
 */

public class _264_Ugly_Number_II {
	
	public static void main(String args[]){
		System.out.println(nthUglyNumber(11));
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
		int counter=0;
		int a1=0,b1=0,c1=0;
		int a2=0,b2=0,c2=0;
		int a3=0,b3=0,c3=0;
		int r1=power(a1+1,b1,c1), r2=power(a2,b2+1,c2), r3=power(a3,b3,c3+1);
		int min=Math.min(r1, Math.min(r2,r3));
		if(min==r1) a1++;
		return 0;
	}
	
	public static int power(int a,int b,int c){
		return (int) (Math.pow(2, a)*Math.pow(3, b)*Math.pow(5, c));
	}
}
