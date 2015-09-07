package com.njz.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _015_threeS1um {
	
	static List<List<Integer>> rs = new ArrayList<List<Integer>>();
	
	
    public static List<List<Integer>> threeSum(int[] nums) {
    	if(nums==null || nums.length<3)
    		return rs;

    	//排序
    	Arrays.sort(nums);

    	int len = nums.length;
    	for(int i=0; i<len; i++){
        	if(i>0 && nums[i] == nums[i-1])
        		continue;
    		find(nums,i+1,len-1,nums[i]);
    	}
    	return rs;
    }
    
	public static void find(int[] nums, int l, int r, int target) {
		int begin = l;
		int end = r;
    	while(begin < end){
    		if(nums[begin]+nums[end]+target==0){
    			List<Integer> tmp = new ArrayList<Integer>();
    			tmp.add(target);
    			tmp.add(nums[begin]);
    			tmp.add(nums[end]);
    			rs.add(tmp);
    			while(begin<end && nums[begin]==nums[begin+1]) begin++;
    			while(begin<end && nums[end] == nums[end-1]) end--;
        		begin++;
        		end--;
    		}else if(nums[begin]+nums[end]+target>0){
    			end--;
    		}else{
    			begin++;
    		}
    	}
	}
	
	
	public static void main(String[] args) {
//		int[] num = {-1,1,1,-1,0,0,0,3,2,0,5};
		int[] num = {-1,-6,-3,-7,-4,-4,0,3,-2,-10,-10,9};
//		int[] num = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		List<List<Integer>> rs1 = threeSum(num);
		System.out.println("all Done!");
		for(List<Integer> a : rs1){
			for(int k : a)
				System.out.print(k+" ");
			System.out.print("-----");
		}
	}

}
