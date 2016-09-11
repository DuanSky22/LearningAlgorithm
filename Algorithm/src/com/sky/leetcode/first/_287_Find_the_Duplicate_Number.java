package com.sky.leetcode.first;

public class _287_Find_the_Duplicate_Number {

	public static void main(String args[]){
		_287_Find_the_Duplicate_Number test = new _287_Find_the_Duplicate_Number();
		int[] nums = {1,2,3,4,2};
		System.out.println(test.findDuplicate(nums));
	}
	public int findDuplicate(int[] nums) {
        while(true){
    		if(nums[nums[0]] == nums[0]) return nums[0];
    		else swap(nums,0,nums[0]);
        }
    }

	private void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}
