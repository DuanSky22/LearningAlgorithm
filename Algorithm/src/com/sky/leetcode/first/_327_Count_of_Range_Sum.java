package com.sky.leetcode.first;
/**
 * @author DuanSky
 * @date 2016年1月12日 下午8:06:00
 * @content 
 */

public class _327_Count_of_Range_Sum {
	
	
	
	//缓存计算结果，不需要每个都计算。
	public int countRangeSum_(int[] nums,int lower,int upper){
		int n = nums.length;
		int sums[] = new int[n+1];
		for(int i=0;i<n;i++){
			sums[i+1]=sums[i]+nums[i];
		}
		int ans = 0;
	    for (int i = 0; i < n; ++i)
	        for (int j = i + 1; j <= n; ++j)
	            if (sums[j] - sums[i] >= lower && sums[j] - sums[i] <= upper)
	                ans++;
	    return ans;
	}
	
	
	//直接计算
	public int countRangeSum(int[] nums, int lower, int upper) {
		int counter=0;
        for(int i=0;i<nums.length;i++){
        	for(int j=i;j<nums.length;j++){
        		int sum = count(nums,i,j);
        		if(sum>=lower && sum<=upper)
        			counter++;
        	}
        }
        return counter;
    }
	
	public int count(int[] nums,int start,int end){
		int result=0;
		for(int i=start;i<=end;i++)
			result+=nums[i];
		return result;
	}

}
