package com.sky.leetcode.first;
/**
 * @author DuanSky
 * @date 2015年12月12日 下午10:32:12
 * @content 
 */

public class _081_SearchinRotatedSortedArrayII {
	
	public static void main(String args[]){
		int[] nums={1,3,5};
		int target=1;
		System.out.println(search_more_fast(nums,target));
	}
	
	public boolean search(int[] nums,int target){
		return _search(nums,0,nums.length-1,target);
	}
	
	public static boolean search_more_fast(int[] nums,int target){
		int low=0;int high=nums.length-1;
		while(low<=high){
			int middle=(high-low)/2+low;
			if(low==middle)
				return target==nums[low] || target==nums[high];
			if(target==nums[middle]) return true;
			if(target>nums[high])
				high=middle;
			else if(target<nums[high])
				low=middle;
			else
				return true;
		}
		return false;
	}
	
	//递归版
	public boolean _search(int[] nums,int start,int end,int target){
		if(start>end) return false;
		if(start==end) return nums[start]==target;
		int middle=(end-start)/2+start;
		if(nums[middle]==target)return true;
		return _search(nums,start,middle,target) || _search(nums,middle+1,end,target);
	}

}
