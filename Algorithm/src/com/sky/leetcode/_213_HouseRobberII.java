/**
* @author DuanSky
* @date 2015年10月30日 下午4:51:52
* @content 
*/
package com.sky.leetcode;

import java.util.Arrays;

public class _213_HouseRobberII {
	
	public static void main(String args[]){
		int nums[]={1};
		System.out.println(rob(nums));
		System.out.println(rob2(nums));
	}
	
	public static int rob2(int nums[]){
		if(nums.length==0) return 0;
		if(nums.length==1) return nums[0];
		int first=0;int second=0;int temp=0;
		for(int i=1;i<nums.length;i++){
			temp=first;
			first=Math.max(first, second+nums[i]);
			second=temp;
		}
		int result1=first;
		 first=0; second=0; temp=0;
		for(int i=0;i<nums.length-1;i++){
			temp=first;
			first=Math.max(first, second+nums[i]);
			second=temp;
		}
		int result2=first;
		return Math.max(result1, result2);
	}
	
	
	public static int rob(int nums[]){
		if(nums.length==0) return 0;
		if(nums.length==1) return nums[0];
		//a[k] means the max money he can rob from nums[0],...nums[k].
		int first=nums[1];int second=nums[0];int temp=0;
		for(int i=2;i<nums.length;i++){
			temp=first;
			first=Math.max(first, second+nums[i]);
			second=temp;
		}
		return first;
	}

}
