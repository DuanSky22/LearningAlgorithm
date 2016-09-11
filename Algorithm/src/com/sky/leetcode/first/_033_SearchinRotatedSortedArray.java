/**
* @author DuanSky
* @date 2015��12��4�� ����9:26:34
* @content 
* 采用二分法的思想来解决问题
*/
package com.sky.leetcode.first;

public class _033_SearchinRotatedSortedArray {
	
	
	public static void main(String args[]){
		int[] nums={4,5,6,7,8,1,2,3};
		int target=9;
		System.out.print(search(nums,target));;
	}
	
	public static int search(int[] nums,int target){
		return _search(nums,0,nums.length-1,target);
	}
	
	public static int _search(int[] nums,int start,int end, int target){
		if(start>end)
			return -1;
		if(start==end)
			return target==nums[start] ? start : -1;
		int middle=(end-start)/2+start;
		if(nums[middle]==target)
			return  middle;
		return Math.max(_search(nums,start,middle,target),_search(nums,middle+1,end,target));
	}
}
