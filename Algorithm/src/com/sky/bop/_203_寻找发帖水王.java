package com.sky.bop;

public class _203_寻找发帖水王 {
	
	public int solution(int[] nums){
		int candidate = 0, times = 0, n = nums.length;
		for(int i = 0; i < n; i++){
			if(times == 0){//经过前面的删除成对不同元素的操作，已经没有候选元素剩下了
				candidate = nums[i];
				times = 1;
			}else{
				if(nums[i] == candidate) times++;
				else times--;
			}
		}
		return candidate;
	}
	
	public int[] solution1(int[] nums){
		int candidates[] = new int[3], times[] = new int[3], n = nums.length;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < 3; j++){
				if(times[j]==0){
					candidates[j] = nums[i];
					times[j] = 1;
					break;
				}
			}
			boolean isFind = false;
			for(int j = 0; j < 3; j++){
				if(candidates[j] == nums[i]){
					times[j]++;
					break;
				}
			}
			if(!isFind){
				for(int j = 0; j < 3; j++)
					times[j]--;
			}
		}
		return candidates;
	}
}
