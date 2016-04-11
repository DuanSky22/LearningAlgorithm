package com.sky.leetcode;

public class _152_Maximum_Product_Subarray {
	
	public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int lastMax = nums[0], lastMin = nums[0], max = nums[0];
        for(int i = 1; i < nums.length; i++){
        	int tempMax = Math.max(Math.max(nums[i], lastMax * nums[i]),lastMin * nums[i]);
        	int tempMin = Math.min(Math.min(nums[i], lastMax * nums[i]),lastMin * nums[i]);
        	lastMax = tempMax; lastMin = tempMin;
        	max = Math.max(lastMax, max);
        }
        return max;
    }

}
