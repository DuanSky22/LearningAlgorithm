package com.sky.bop;
/**
 * @author DuanSky
 * @date 2016年5月4日 下午4:31:42
 * @content 
 */

public class _214_求数组的子数组之和的最大值 {
	
	public static void main(String args[]){
		int[] nums = {-2,5,3,-6,8,-8,6};
		_214_求数组的子数组之和的最大值 test = new _214_求数组的子数组之和的最大值();
		System.out.println(test.maxSubSum(nums));
	}
	
	public int maxSubSum(int[] nums){
		if(nums == null || nums.length == 0) return 0;
		int before = 0,res = 0;//before表示以当前位置结尾的最大子数组之和。
		for(int i = 0; i < nums.length; i++){
			before = Math.max(before+nums[i], nums[i]); 
			res = Math.max(res, before);
		}
		return res;
	}

}
