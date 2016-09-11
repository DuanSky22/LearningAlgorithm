package com.sky.bop;

public class _211_寻找最近点对 {
	
	public static void main(String args[]){
		int[] nums = {9,7,1};
		_211_寻找最近点对 test = new _211_寻找最近点对();
		System.out.println(test.findMinGap0(nums));
	}
	
	//采用分而治之的思想，将原来的问题分解成两个子问题，并且将子问题合并。类似归并排序。
	public long findMinGap0(int[] nums){
		return findMinGap0(nums,0,nums.length-1);
	}

	private long findMinGap0(int[] nums, int start, int end) {
		if(start >= end) return Long.MAX_VALUE; //只有一个元素
		else if(start + 1 == end) return Math.abs((long)(nums[start]-nums[end]));//只有两个元素
		int middle = end, pivot = nums[start],leftMax = pivot,rightMin = Integer.MAX_VALUE; //以左边的元素作为支点
		for(int i = start + 1; i <= middle; i++){//将小于支点的元素放在左边，大于支点的元素放在右边
			if(nums[i] == pivot) return 0;
			else if(nums[i] > pivot) {
				rightMin = Math.min(rightMin, nums[i]);
				swap(nums,i--,middle--);
			}
		}
		swap(nums,start,middle);
		long left = findMinGap0(nums,start,middle);
		long right = findMinGap0(nums,middle+1,end);
		long cox = middle == end ? Long.MAX_VALUE : (rightMin - leftMax);
		return left < right ? (left < cox ? left : cox) : (right < cox ? right : cox);
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
