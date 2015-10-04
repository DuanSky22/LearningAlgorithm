package com.sky.leetcode;

public class _198_HouseRobber {
	
	public  static void main(String args[]){
		int[] nums={1,2,3,4,5,6,7};
		System.out.println(rob(nums));
		System.out.println(rob0(nums));
	}
	
	//we assume result[i] represent the max money that if he robot house i.
	public static int rob(int[] nums) {
        if(nums.length<=0)
            return 0;
        int [] result=new int[nums.length];
        result[0]=nums[0];
        if(nums.length>=2){
            result[1]=Math.max(nums[0],nums[1]);
            for(int i=2;i<nums.length;i++){
                int max=0;
                for(int t=0;t<=i-2;t++)
                    if(result[t]>max)
                        max=result[t];
                result[i]=max+nums[i];
            }
        }
        int answer=0;
        for(int i=0;i<result.length;i++)
            if(result[i]>answer)
                answer=result[i];
        return answer;
    }
	
	/*
	 * s[k] represent max money can robot from a[1,...,k].
	 * s[k]=max{s[k-1],s[k-2]+a[k]}
	 */
	
	public static int rob0(int[] nums){
		int temp0=0; //s[k-2]
		int temp1=0; //s[k-1]
		int temp2=0;
		for(int i=0;i<nums.length;i++){
			temp2=Math.max(temp0+nums[i], temp1);
			temp0=temp1;
			temp1=temp2;
		}
		return Math.max(temp1, temp2);
	}
}
