package com.sky.topic.dynamic_programming;
/**
 * @author DuanSky
 * @date 2016年3月5日 下午9:52:51
 * @content 
 */

public class _01_DP_Arrays_max_sub_sum_array {
	
	public static void main(String args[]){
		_01_DP_Arrays_max_sub_sum_array test = new _01_DP_Arrays_max_sub_sum_array();
		int[] nums={1};
		System.out.println(test.solution(nums));
	}
	
	public int solution(int[] nums){
		if(nums==null || nums.length==0) return Integer.MIN_VALUE;
		int[] d = new int[nums.length]; d[0]=nums[0];
		int max = d[0];
		for(int i=1;i<nums.length;i++){
			d[i]=Math.max(d[i-1]+nums[i], nums[i]);
			max = Math.max(max, d[i]);
		}
		return max;
	}

}
