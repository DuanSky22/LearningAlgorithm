/**
* @author DuanSky
* @date 2015��10��8�� ����7:49:42
* @content 
*/
package com.sky.leetcode.first;

public class _026_RemoveDuplicatesfromSortedArray {
	
	public static void main(String args[]){
		int[] nums={1,1,1,2,2,3,3,3};
		System.out.println(removeDuplicates(nums));
		System.out.println(removeDuplicates0(nums));
	}
	
	//this method spends o(n^2) time space.
	public static int removeDuplicates(int[] nums) {
        int k=nums.length;
        if(k==0)
            return 0;
        int current=nums[0];
        for(int i=1;i<k;i++){
            if(current==nums[i]){
                int t=i;
                while(t<k-1){
                    nums[t]=nums[t+1];
                    t++;
                }
                i--;
                k--;
            }
            current=nums[i];
        }
        return k;
    }
	
	/*
	 * just like the method up show, if the former element equals the latter element,
	 * we need to move the element. BUT this is not necessary.
	 * We just need to record the difference element and it's position.
	 */
	
	public static int removeDuplicates0(int[] nums){
		if(nums.length<2)
			return nums.length;
		int id=1;
		for(int i=1;i<nums.length;i++){
			if(nums[i]!=nums[i-1])
				nums[id++]=nums[i];
		}
		return id;
	}
}
