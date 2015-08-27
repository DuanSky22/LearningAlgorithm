package com.njz.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class _018_fourSum {
    
	static List<List<Integer>> rs = new ArrayList<List<Integer>>();
	
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		if(nums == null || nums.length==0)
			return rs;
		
		int len = nums.length;
		Arrays.sort(nums);
		
		for(int i=0; i<len-3; i++){
			if(i!=0 && nums[i]==nums[i-1])
				continue;
			
			for(int j=i+1; j<len-2; j++){
				if(j!=i+1 && nums[j]==nums[j-1])
					continue;
				
				find(nums,i,j,j+1,len-1,target);
			}
		}
		return rs;
    }
	
	private static void find(int[] nums, int i, int j, int start, int end, int target) {
		int f1 = nums[i];
		int f2 = nums[j];
		while(start < end){
			if(f1+f2+nums[start]+nums[end] == target){
				List<Integer> tmp = new ArrayList<Integer>();
				tmp.add(f1);
				tmp.add(f2);
				tmp.add(nums[start]);
				tmp.add(nums[end]);
				rs.add(tmp);
				while(start<end && nums[end]==nums[end-1]) end--;
				while(start<end && nums[start]==nums[start+1]) start++;
				start++;
				end--;
			}else if(f1+f2+nums[start]+nums[end] > target){
				while(start<end && nums[end]==nums[end-1])
					end--;
				end--;
			}else{
				while(start<end && nums[start]==nums[start+1])
					start++;
				start++;
			}
			
		}//end --- for
	}

	public static void main(String[] args){
//		int[] S = {1,0,-1,0,-2,2};
		int[] S = {-1,2,2,-5,0,-1,4};
		int target = 3;
		List<List<Integer>> rs1 = fourSum(S,target);
		System.out.println("all Done!   target="+target);
		for(List<Integer> a : rs1){
			for(int k : a)
				System.out.print(k+" ");
			System.out.print(" ****** ");
		}
	}
}
