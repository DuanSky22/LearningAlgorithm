package com.sky.leetcode.first;

public class _303_Range_Sum_Query_Immutable {
	
	public class NumArray {
		private int[] nums;
		private int[] sums;
	    public NumArray(int[] nums) {
	        if(nums == null || nums.length == 0) return;
	        this.nums = nums;
	        int n = nums.length;
	        sums = new int[n]; sums[0] = nums[0];
	        for(int i = 1; i < nums.length; i++){
	        	sums[i] = sums[i-1] + nums[i];
	        }
	    }

	    public int sumRange(int i, int j) {
	        return sums[j] - sums[i] + nums[i];
	    }
	}

}
