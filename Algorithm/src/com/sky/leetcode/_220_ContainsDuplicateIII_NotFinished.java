/**
* @author DuanSky
* @date 2015年9月29日 下午9:57:33
* @content 
*/
package com.sky.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _220_ContainsDuplicateIII_NotFinished {
	
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		
		
		//solution 1-here is o(n^2)
//        if(nums.length>0){
//        	for(int i=0;i<nums.length;i++){
//        		int former=i+1;
//        		while(former<=i+k && former<nums.length){
//        			if(nums[former]-nums[i]<=t && nums[former]-nums[i]>=-t)
//        				return true;
//        			former++;
//        		}
//        	}
//        }
//        return false;
		//solution-2 here is o(n*t)
//		if(nums.length>0){
//			Map<Integer,Integer> map=new HashMap<Integer,Integer>();
//			for(int i=0;i<nums.length;i++){
//				if(map.containsKey(nums[i]))
//					if(i-map.get(nums[i])<=k)
//						return true;
//					else
//						for(int z=-t;z<=t;z++)
//							map.put(nums[i]+z, i);
//				else
//					for(int z=-t;z<=t;z++)
//						map.put(nums[i]+z, i);
//			}
//		}
//		return false;
		
		//solution 3
//		if(nums.length>0){
//			
//		}
		return false;
    }

}
