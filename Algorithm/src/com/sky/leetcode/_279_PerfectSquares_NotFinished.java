/**
* @author DuanSky
* @date 2015年10月12日 下午8:17:04
* @content 
*/
package com.sky.leetcode;

public class _279_PerfectSquares_NotFinished {
	
	public static void main(String args[]){
		int n=12;
		System.out.println(numSquares(n));
	}
	
	public static int numSquares(int n) {
        int count=0;
        while(n!=0){
            int x=(int) Math.sqrt(n);
            n-=x*x;
            count++;
        }
        return count;
    }

}
