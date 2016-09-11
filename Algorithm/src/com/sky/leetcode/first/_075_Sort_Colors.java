package com.sky.leetcode.first;
/**
 * @author DuanSky
 * @date 2016年1月4日 下午2:05:20
 * @content 
 */

public class _075_Sort_Colors {
	
	public static void main(String args[]){
		int[] nums={1,2,0};
		sortColors_(nums);
	}
	
	public static void sortColors(int[] nums) {
        if(nums.length<2) return;
        int _0=0; int _1=0; int _2=0;
        for(int num : nums){
        	if(num==0) _0++;
        	else if(num==1) _1++;
        	else _2++;
        }
        int i=0;
        while(i<_0) nums[i++]=0;
        while(i<_1+_0) nums[i++]=1;
        while(i<_2+_1+_0) nums[i++]=2;
    }
	
	public static void sortColors_(int[] nums){
		if(nums.length<2) return;
		int i=-1; int j=nums.length; int k=0;
		while(k<j){
			if(nums[k]==0)
				swap(nums,k,++i);
			if(nums[k]==2)
				swap(nums,k--,--j);
			k++;
		}
	}
	
	public static void swap(int[] nums,int i,int j){
		int temp=nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}
}
