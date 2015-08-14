package com.sky.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _002_MajorityElementII {

	public static List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        if(n==0)
            return new ArrayList<Integer>();
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i]))
                map.put(nums[i],map.get(nums[i])+1);
            else
                map.put(nums[i],1);
        }
        List<Integer> list=new ArrayList<Integer>();
        for(java.util.Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue()>n/3)
                list.add(entry.getKey());
        }
        return list;
    }
}
