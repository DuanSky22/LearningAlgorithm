/**
* @author DuanSky
* @date 2015��9��28�� ����10:23:03
* @content 
*/
package com.sky.leetcode.first;

public class _283_MoveZeroes {

	public static void main(String args[]){
		int[] nums={1,2,0,3,0,7,0,0};
		moveZeroes(nums);
		System.out.println(nums);
	}
	public static void moveZeroes(int[] nums) {
        if(nums.length<=0)
        	return;
        int current=nums.length-1;
        for(int i=current;i>=0;i--){
        	if(nums[i]==0){
        		int temp=i;
        		while(temp<current){
        			nums[temp]=nums[temp+1];
        			temp++;
        		}
        		nums[temp]=0;
        		current--;
        	}
        }
    } 
}
