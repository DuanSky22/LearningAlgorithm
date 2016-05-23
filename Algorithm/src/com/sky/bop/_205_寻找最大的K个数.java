package com.sky.bop;

import java.util.Arrays;
import java.util.Random;

public class _205_寻找最大的K个数 {
	
	private Random random = new Random();
	public static void main(String args[]){
		_205_寻找最大的K个数 test = new _205_寻找最大的K个数();
		int[] nums = {8,7,6,5,4,3,2,1,9};
//		test.quickSort(nums);
		int k = 4;
		int[] ks = test.solution(nums, k);
	}
	 
	//利用快速排序思想
	public int[] solution(int[] nums,int k){
		if(k <= 0) return new int[]{};
		else if(k >= nums.length) return Arrays.copyOf(nums, nums.length);
		return quickSort(nums, 0, nums.length - 1, k);
	}

	//[start,end]
	private int[] quickSort(int[] nums, int start, int end, int k) {
		int pos = random.nextInt(end - start + 1) + start, pivot = nums[pos];
		int middle = end;
		for(int i = start; i <= middle; i++){
			if(nums[i] < pivot)
				swap(nums,i--,middle--);
		}
		swap(nums,pos,middle);
		if(middle - start + 1 == k) return Arrays.copyOfRange(nums, start, end+1);
		else if(middle - start + 1 > k) return quickSort(nums,start,middle-1,k);
		else{
			int[] res = new int[k];
			for(int i = start; i <= middle; i++)
				res[i-start]=nums[i];
			int[] right = quickSort(nums,middle+1,end,k-(middle-start+1));
			for(int i = middle - start + 1; i < k; i++)
				res[i] = right[i-(middle-start+1)];
			return res;
		}
	}

	public void quickSort(int[] nums){
		if(nums == null || nums.length <= 1) return;
		quickSort(nums,0,nums.length-1);
	}

	private void quickSort(int[] nums, int start, int end) {
		if(start >= end) return;
		int pivot = nums[start]; int middle = end;
		for(int i = start + 1; i <= middle; i++){//采用end作为分界点
			if(nums[i] > pivot){
				swap(nums,i--,middle--);
			}
		}
		swap(nums,start,middle);
		quickSort(nums,start,middle-1);
		quickSort(nums,middle+1,end);
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp; 
	}
}
