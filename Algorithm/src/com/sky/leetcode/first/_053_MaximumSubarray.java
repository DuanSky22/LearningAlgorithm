/**
* @author DuanSky
* @date 2015年10月28日 下午1:06:23
* @content 
*/
package com.sky.leetcode.first;

public class _053_MaximumSubarray {
	
	public static void main(String args[]){
		int[] nums={-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}
	
	public static int maxSubArray(int[] nums) {
        if(nums.length==0)
        	return 0;
        /*
         * define d[k] means the max value of 1...k(which must contains k)
         * then d[k+1]=d[k]+nums[k+1](d[k]>0) || nums[k+1](d[k]<=0)
         */
        int max=nums[0];int temp=max;int lastMax=nums[0];
        for(int i=1;i<nums.length;i++){
        	lastMax= lastMax > 0 ? lastMax+nums[i] : nums[i];
        	max=Math.max(max, lastMax);
        }
        return max;
    }

}
