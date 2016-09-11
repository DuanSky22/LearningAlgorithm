package com.sky.bop;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author DuanSky
 * @date 2016年5月4日 下午2:58:13
 * @content 
 */

public class _212_快速寻找满足条件的两个数 {
	
	public static void main(String args[]){
		int[] nums = {3,2,4};
	}
	
	//采用hash map
	public int[] toSum0(int[] nums,int sum){
		if(nums == null || nums.length < 2) return new int[]{-1,-1};
		Map<Integer,Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++){
			if(map.containsKey(sum-nums[i]))
				return new int[]{map.get(sum-nums[i]),i};
			else
				map.put(nums[i], i);
		}
		return new int[]{-1,-1};
	}
	
	//存在则返回数组下标，不存在则返回-1,-1
	public int[] twoSum(int[] nums,int sum){
		if(nums == null || nums.length < 2) return new int[]{-1,-1};
		Arrays.sort(nums);
		for(int i = 0, j = nums.length - 1; i < j;){
			int currSum = nums[i] + nums[j];
			if(currSum == sum) return new int[]{i,j}; //MISTAKE 这样已排序，下标岂不乱了？
			else if(currSum < sum) i++;
			else j--;
		}
		return new int[]{-1,-1};
	}

}
