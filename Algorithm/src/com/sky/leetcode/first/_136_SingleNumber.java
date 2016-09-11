/**
* @author DuanSky
* @date 2015��10��25�� ����1:34:19
* @content 
*/
package com.sky.leetcode.first;

public class _136_SingleNumber {
	public int singleNumber(int[] nums) {
        int result=0;
        for(int i=0;i<nums.length;i++)
            result ^=nums[i];
        return result;
    }
}
