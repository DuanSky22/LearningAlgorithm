/**
* @author DuanSky
* @date 2015��9��30�� ����9:36:54
* @content 
*/
package com.sky.leetcode.first;

public class _070_ClimbingStairs {
	
	public static void main(String args[]){
		int n=50;
		long t1=System.currentTimeMillis();
		System.out.println(climbStairs(n));
		System.out.println(System.currentTimeMillis()-t1);
		System.out.println("========");
		t1=System.currentTimeMillis();
		System.out.println(climbStairs0(n));
		System.out.println(System.currentTimeMillis()-t1);
	}
	
	//dynamic program
	public static int climbStairs(int n) {
		
        return n<=1 ? 1 : climbStairs(n-1)+climbStairs(n-2);
    }
	
	//
	public static int climbStairs0(int n){
		if(n<0) return 0;
		if(n==1) return 1;
		if(n==2) return 2;
		
		int latter=1;
		int former=2;
		int all=0;
		for(int i=2;i<n;i++){
			all=latter+former;
			latter=former;
			former=all;
		}
		return all;
	}

}
