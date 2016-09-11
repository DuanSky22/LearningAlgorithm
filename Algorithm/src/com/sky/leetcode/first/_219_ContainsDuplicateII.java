/**
* @author DuanSky
* @date 2015��9��29�� ����9:39:48
* @content 
*/
package com.sky.leetcode.first;

import java.util.HashMap;
import java.util.Map;

public class _219_ContainsDuplicateII {
	
	public static void main(String args[]){
		System.out.println(containsNearbyDuplicate(new int[]{-1,-1},1));
	}
	
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
	       if(nums.length>0){
	    	   Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		       for(int i=0;i<nums.length;i++){
		    	   if(map.containsKey(nums[i])){
		    		   if(i-map.get(nums[i])<=k)
		    			   return true;
		    		   else
		    			   map.put(nums[i], i);
		    	   }
		    	   else
		    		   map.put(nums[i],i);
		       } 
	       }
	       return false;
    }
}
