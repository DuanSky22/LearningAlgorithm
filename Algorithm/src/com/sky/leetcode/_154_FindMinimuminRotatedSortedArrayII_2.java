/**
* @author DuanSky
* @date 2015年10月28日 下午7:36:38
* @content 
*/
package com.sky.leetcode;

public class _154_FindMinimuminRotatedSortedArrayII_2 {
	
	public static void main(String args[]){
		int[] nums={4,5,6,7,0,1,2,3};
		System.out.println(findMin(nums));
	}
	public static int findMin(int[] nums) {
        int low=0;int high=nums.length-1;
        while(low<high){
            int mid=(low+high)/2;
            if(nums[mid]>nums[high])
            	low=mid+1;
            else if(nums[mid]<nums[high])
            	high=mid;
            else
            	low++;
        }
        return nums[low];
    }
}
