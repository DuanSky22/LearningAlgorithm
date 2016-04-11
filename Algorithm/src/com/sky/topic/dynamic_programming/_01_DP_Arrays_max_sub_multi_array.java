package com.sky.topic.dynamic_programming;
/**
 * @author DuanSky
 * @date 2016年3月6日 下午4:43:40
 * @content 
 */

public class _01_DP_Arrays_max_sub_multi_array {
	
	public static void main(String args[]){
		_01_DP_Arrays_max_sub_multi_array test = new _01_DP_Arrays_max_sub_multi_array();
		int[] nums = {-2,2};
		System.out.println(test.solution(nums));
	}
	//给定长度为N的数组，只允许用乘法，不允许用除法，计算任意（N-1）个数的组合中乘积最大的一组。
	public int solution(int[] nums){
		if(nums==null || nums.length<=1) return Integer.MIN_VALUE;
		int[] p = new int[nums.length]; p[0]=1;
		int[] q = new int[nums.length]; q[nums.length-1]=1;
		int max = 0;
		for(int i=0;i<nums.length-1;i++){
			p[i+1]=p[i]*nums[i];
			q[nums.length-2-i]=q[nums.length-1-i]*nums[nums.length-1-i];
		}
		for(int i=0;i<nums.length;i++)
			max = Math.max(max, p[i]*q[i]);
		return max;
	}

}
