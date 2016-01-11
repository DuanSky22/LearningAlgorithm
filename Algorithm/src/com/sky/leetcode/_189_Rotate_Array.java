package com.sky.leetcode;

import java.util.Arrays;

/**
 * @author DuanSky
 * @date 2015年12月24日 下午8:58:51
 * @content 
 */

public class _189_Rotate_Array {
	public static void main(String args[]){
		int[] nums=new int[]{1,2};
		int k=3;
		rotate(nums,k);
	}
	public static void rotate(int[] nums, int k) {
		int n=nums.length;
        if(n==0 || n==1 || k==0) return;
        int pos=k % n;
        if(pos==0) return;
        int[] temp=Arrays.copyOf(nums, n);
        for(int i=0;i<n-pos;i++)
        	nums[pos+i]=temp[i];
        for(int i=0;i<pos;i++)
        	nums[i]=temp[n-pos+i];
    }
}
