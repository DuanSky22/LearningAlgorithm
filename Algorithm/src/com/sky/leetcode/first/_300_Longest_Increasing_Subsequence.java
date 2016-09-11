package com.sky.leetcode.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _300_Longest_Increasing_Subsequence {
	
	public static void main(String args[]){
		int[] nums = {9,10,11,1,2,12,3,4,5};
		_300_Longest_Increasing_Subsequence test = new _300_Longest_Increasing_Subsequence();
		System.out.println(test.lengthOfLIS(nums));
		System.out.println(test.lengthOfLIS0(nums));
		System.out.println(test.lengthOfLIS1(nums));
	}
	/*
	 * o(n^2) solution.
	 */
	 public int lengthOfLIS(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
        int n = nums.length, res = 0;
        int dp[] = new int[n];  //dp[i]:以i结尾的最长增长字串长度
        for(int i = 0; i < n; i++){
        	dp[i] = 1;//MISTAKE 注意需要初始化为1
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i],dp[j]+1);
            }
            res = Math.max(res,dp[i]);
        }
        return res;
	 }
	 /*
	  * o(nlog(n)) solution.
	  */
	 public int lengthOfLIS0(int[] nums){
		if(nums == null || nums.length == 0) return 0;
		int n = nums.length, currLen = 0;
		int[] dp = new int[n];
		for(int num : nums){
			int i = Arrays.binarySearch(dp, 0,currLen,num);
			if(i < 0) 
				i = -( i + 1 );
			dp[i] = num;
			if(i == currLen) currLen++;
		}
		return currLen;
	 }
	 public int lengthOfLIS1(int[] nums){
		 if(nums == null || nums.length == 0) return 0;
		 List<Integer> list = new ArrayList<>();
		 for(int num : nums){
			 int i = Collections.binarySearch(list, num);
			 if(i < 0) i = -(i+1); //元素插入的位置
			 if(i != list.size()) 
				 list.remove(i);
			 list.add(i,num);
		 }
		 return list.size();
	 }
}
