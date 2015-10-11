/**
* @author DuanSky
* @date 2015年10月11日 下午12:52:25
* @content 
*/
package com.sky.leetcode;

public class SingleNumberII {
	public static void main(String args[]){
		int[] nums={1,1,1,2};
		System.out.println(singleNumber(nums));
	}
	public static int singleNumber(int[] nums) {
        int first=0;
        int second=0;
        for(int i=0;i<nums.length;i++){
        	first=(first^nums[i])&(~second);
        	second=(second^nums[i])&(~first);
        }
        return first;
    }

}
