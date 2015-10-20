/**
* @author DuanSky
* @date 2015年10月19日 下午6:08:16
* @content 
*/
package com.sky.leetcode;

public class _268_MissingNumber {
	public static void main(String args[]){
		int[] nums={1};
		System.out.println(missingNumber(nums));
	}
	public static int missingNumber(int[] nums) {
        int result=0;int i=0;
        for(;i<nums.length;i++){
            result^=nums[i];
            result^=i;
        }
        result^=i;
        return result;
    }
}
