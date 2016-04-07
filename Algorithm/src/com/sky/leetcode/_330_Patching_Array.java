package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2016年3月9日 上午10:21:16
 * @content 
 * [1,2,31,33]
2147483647
 */

public class _330_Patching_Array {
	
	public static void main(String args[]){
		_330_Patching_Array test = new _330_Patching_Array();
		int[] nums = {};
		int n = 8;
		System.out.println(test.minPatches(nums, n));
	}

	public int minPatches(int[] nums, int n) {
        long miss = 1;//MISTAKE 注意必须得用long类型，不然会溢出！！！
        int count = 0, i = 0;
        while(miss <= n){
        	if(i<nums.length && nums[i]<=miss){
        		miss+=nums[i++];
        	}
        	else{
        		miss+=miss;
        		count++;
        	}
        }
        return count;
    }
}
