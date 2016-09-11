/**
* @author DuanSky
* @date 2015��10��28�� ����7:10:53
* @content 
*/
package com.sky.leetcode.first;

public class _153_FindMinimuminRotatedSortedArray {
	
	public static void main(String args[]){
		int[] nums={4,5,6,7,8,0,1,2,3};
		System.out.println(findMin(nums));
	}
	
	public static int findMin(int[] nums) {
		int low=0;
		int high=nums.length-1;
		while(low<high){
			int mid=(low+high)/2;
			if(nums[mid]>nums[high])
				low=mid+1;
			else
				high=mid;
		}
		return nums[low];
    }

}
