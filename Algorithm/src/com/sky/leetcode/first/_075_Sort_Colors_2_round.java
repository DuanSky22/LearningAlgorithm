package com.sky.leetcode.first;
/**
 * @author DuanSky
 * @date 2016年3月7日 下午11:09:03
 * @content 
 */

public class _075_Sort_Colors_2_round {
	
	public static void main(String args[]){
		int[] nums = {2,2,1};
		_075_Sort_Colors_2_round test = new _075_Sort_Colors_2_round();
		test.sortColors(nums);
	}
	
	public void sortColors(int[] nums) {
        if(nums.length<3) return;
        int start = -1, end = nums.length;
        for(int i=0;i<end;i++){
        	if(nums[i]==0){
        		start++;
        		swap(nums,i,start);
        	}
        	else if(nums[i]==2){
        		end--;
        		swap(nums,i,end);
        		i--;
        	}
        }
    }
    public  void swap(int[] nums,int i,int j){
		int temp=nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}
}
