package com.sky.topic.dynamic_programming;
/**
 * @author DuanSky
 * @date 2016年3月5日 下午10:09:06
 * @content 
 */

public class _01_DP_Arrays_max_sub_increase_array {
	
	public static void main(String args[]){
		_01_DP_Arrays_max_sub_increase_array test = new _01_DP_Arrays_max_sub_increase_array();
		int[] nums = {1,-1,2,-3,4,-5,6,-7,8};
		System.out.println(test.solution_2(nums));
	}
	
	//下面的方法解决的问题是 子序列不需要是连续的最长增长子序列
	public int solution_2(int[] nums){
		if(nums == null || nums.length == 0) return 0;
		int max = 1, d[] = new int[nums.length]; 
		for(int i=0;i<nums.length;i++) d[i]=1;
		for(int i=1;i<nums.length;i++){
			for(int k=0;k<i;k++)
				if(nums[k]<nums[i]) d[i]=Math.max(d[i], d[k]+1);
			max = Math.max(d[i], max);
		}
		return max;
	}
	
	//下面的方法解决的问题是 子序列必须是连续的最长增长子序列
	public int solution_1(int[] nums){
		if(nums==null || nums.length==0) return 0;
		int[] d = new int[nums.length]; d[0]=1;
		int max = 0;
		for(int i=1;i<nums.length;i++){
			d[i] = nums[i]>nums[i-1] ? (d[i-1] + 1) : 1;
			max = Math.max(d[i], max);
		}
		return max;
	}

}
