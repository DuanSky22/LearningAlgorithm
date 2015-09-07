package com.xingkong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
	public static void main(String[] args){
		TwoSum_1 tt=new TwoSum_1();
		int[] numbers={2,7,11,15};
		int target=9;
		int[] result=tt.twoSum(numbers,target);
		System.out.println(result[0]+" "+result[1]);
	}
	public int[] twoSum(int[] nums, int target) {
		int[] result=new int[2];
		Map<Integer,Integer> indexMap=new HashMap<Integer,Integer>();
		//存放数组的位置信息
		for(int index=0;index<nums.length;index++){
			indexMap.put(nums[index], index);
			
		}
		for(int index=0;index<nums.length;index++){
			if(indexMap.get(target-nums[index])!=null&&index<indexMap.get(target-nums[index])){
				result[0]=index+1;
				result[1]=indexMap.get(target-nums[index])+1;
			}
		}
		
		
        return result;
    }
}
