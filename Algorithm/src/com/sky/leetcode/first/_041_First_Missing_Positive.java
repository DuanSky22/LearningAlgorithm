package com.sky.leetcode.first;

public class _041_First_Missing_Positive {
	
	public static void main(String args[]){
		_041_First_Missing_Positive test = new _041_First_Missing_Positive();
		int[] nums = {1,1};
		System.out.println(test.firstMissingPositive(nums));
	}
	
	public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) return 1;
        int n = nums.length;
        for(int i = 0; i < n; i++){
        	if(nums[i] == i+1) continue;
        	if(nums[i] < 1 || nums[i] > n || nums[nums[i]-1] == nums[i]){//MISTAKE 需要考虑重复的元素
        		nums[i] = 0;
        	}
        	else{
        		int temp = nums[i];
        		nums[i] = nums[temp-1];
        		nums[temp-1] = temp; 
        		i--;
        	}
        }
        for(int k = 0; k < n; k++)
        	if(nums[k] != k+1) return k+1;
        return n+1;
    }
}
