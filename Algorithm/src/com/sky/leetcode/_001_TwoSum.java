package com.sky.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _001_TwoSum {
	
	public static void main(String args[]){
		int [] nums={3,2,4};
		int target=6;
		System.out.println(twoSum(nums,target));
	}

    public static int[] twoSum(int[] nums, int target) {
        if(nums.length==0)
            return new int[]{};
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i]))
                return new int[]{map.get(target-nums[i]),i};
            else
                map.put(nums[i],i+1);
        }
        return new int[]{};
    }
}
