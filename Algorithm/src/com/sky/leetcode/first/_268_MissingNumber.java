/**
* @author DuanSky
* @date 2015��10��19�� ����6:08:16
* @content 
*/
package com.sky.leetcode.first;

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
