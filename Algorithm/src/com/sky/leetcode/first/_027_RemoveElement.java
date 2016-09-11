/**
* @author DuanSky
* @date 2015��9��28�� ����10:32:14
* @content 
*/
package com.sky.leetcode.first;

import java.util.Arrays;

public class _027_RemoveElement {
	public int removeElement(int[] nums, int val) {
        if(nums.length<=0)
        	return 0;
        int current=nums.length-1;
        for(int i=current;i>=0;i--){
        	if(nums[i]==val){
        		nums[i]=nums[current];
        		current--;
        	}
        }
        nums=Arrays.copyOfRange(nums, 0, current+1);
        return current+1;
    }
}
