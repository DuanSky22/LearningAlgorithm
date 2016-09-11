/**
* @author DuanSky
* @date 2015��9��29�� ����11:29:35
* @content 
*/
package com.sky.leetcode.first;

public class _191_Numberof1Bits {
	
	public static void main(String args[]){
		System.out.println(hammingWeight(10));
	}

	public static int hammingWeight(int n) {
        int counter=0;
        while(n!=0){
        	counter+=n^((n>>>1)<<1);
        	n>>>=1;
        }
        return counter;
        // n & 1 we can get the last bit number.
//        while(n!=0){
//        	counter+=n & 1;
//        	n>>>=1;
//        }
    }
}
