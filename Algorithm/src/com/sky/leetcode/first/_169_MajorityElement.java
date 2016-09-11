package com.sky.leetcode.first;

import java.util.HashMap;
import java.util.Map;

public class _169_MajorityElement {
	
	public static void main(String args[]){
		int[] nums={1,1,2,2,2,3,3,3,3,1,1,1};
		System.out.println(majorityElement(nums));
	}
	

    public static int majorityElement(int[] nums) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        int maxCounter=1;
        int majorityElement=nums[0];
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int counter=map.get(nums[i]);
                if(counter+1>maxCounter){
                	maxCounter=counter+1;
                	majorityElement=nums[i];
                }
                map.put(nums[i],counter+1);
            }
            else
                map.put(nums[i],1);
        }
        return majorityElement;
    }
}

