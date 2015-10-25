/**
* @author DuanSky
* @date 2015年10月25日 下午1:34:19
* @content 
*/
package com.sky.leetcode;

public class _136_SingleNumber {
	public int singleNumber(int[] nums) {
        int result=0;
        for(int i=0;i<nums.length;i++)
            result ^=nums[i];
        return result;
    }
}
