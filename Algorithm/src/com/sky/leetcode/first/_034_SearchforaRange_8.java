/**
* @author DuanSky
* @date 2015��10��19�� ����1:44:52
* @content 
*/
package com.sky.leetcode.first;

public class _034_SearchforaRange_8 {
	
	public static void main(String args[]){
		int[] nums={1};
		int target=1;
		System.out.println(searchRange(nums,target));
	}
	
	public static int[] searchRange(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        int middle=0;
        while(low<high){
            middle=(low+high)/2;
            if(nums[middle]<target)
                low=middle+1;
            else
                high=middle;
        }
        int[] result={-1,-1};
        if(nums[low]==target){
            int left=low;
            int right=low;
            while(left>=1 && nums[left-1]==target) //be careful of the condition 
                left--;
            while(right<nums.length-1 && nums[right+1]==target) //be careful of the condition.
                right++;
            result[0]=left;
            result[1]=right;
        }
        return result;
    }
}
