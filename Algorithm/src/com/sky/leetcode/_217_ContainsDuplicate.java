/**
* @author DuanSky
* @date 2015年9月29日 下午8:04:53
* @content 
*/
package com.sky.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _217_ContainsDuplicate {
	
	public static void main(String args[]){
		int[] nums={1,2,3,4,5,6,11};
		System.out.println(containsDuplicate(nums));
	}
	
	public static boolean containsDuplicate(int[] nums) {
        if(nums.length>0){
        	Set<Integer> set=new HashSet<Integer>();
            for(int i=0;i<nums.length;i++){
                if(set.contains((nums[i])))
                    return true;
                else
                    set.add(nums[i]);
            }
        }
        return false;
    }
}
