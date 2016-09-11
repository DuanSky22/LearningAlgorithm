package com.sky.leetcode.first;
/**
 * @author DuanSky
 * @date 2016年3月21日 下午9:55:49
 * @content 
 */

public class _162_Find_Peak_Element {
	
	public static void main(String args[]){
		_162_Find_Peak_Element test = new _162_Find_Peak_Element();
		int[] nums={2,1};
		System.out.println(test.findPeakElement_(nums));
	}
	
	//线性搜索
	public int findPeakElement(int[] nums) {
        if(nums.length == 1 || nums[0]>nums[1]) return 0;
        for(int i = 1; i < nums.length - 1; i++){
        	if(nums[i]>nums[i-1] && nums[i]>nums[i+1]) return i;
        }
        return nums.length - 1;
    }
	//二分搜索
	public int findPeakElement_(int[] nums){
		int low = 0; int high = nums.length -1 ;
		while(low < high){
			int m1 = ( low + high ) / 2;
			int m2 = m1 + 1;
			if(nums[m1] < nums[m2])
				low = m2;
			else
				high = m1;
		}
		return low;
	}
	
}
