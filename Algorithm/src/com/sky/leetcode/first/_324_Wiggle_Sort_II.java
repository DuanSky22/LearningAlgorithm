package com.sky.leetcode.first;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DuanSky
 * @date 2016年3月8日 下午4:07:56
 * @content 
 */

public class _324_Wiggle_Sort_II {
	
	public static void main(String args[]){
		_324_Wiggle_Sort_II test = new _324_Wiggle_Sort_II();
		int[] nums = {10,11,12,13,14,15,16,17,18,19};
		test.wiggleSortII(nums);
		int n = 10;
		System.out.println(test.addSolution(n));
	}
	
	/*
	 * 基本思想是先找出中位数，然后将原来的数组按照大于中位数，等于中位数和小于中位数的次序排列，于是可能有如下的情况：
	 * 高 高 高 高 中 中 低 低 低 选取中位数的目的是保证 | |{高}| - (|{中}| + |{低}|) | <=1
	 * 剩下的任务就是将这些 中 中 低 低 低 插入到 高 的两边 即可。
	 * 在无序数组中找到中位数的时间复杂度是 o(n),而将中和低插入高位置中间的复杂度也是o(n),所以算法的复杂度是o(n)
	 */
	
	public List<String> addSolution(int n){
		List<String> res = new ArrayList<>();
		for(int i = 1; i <= n-i; i++){
			addSolution_(res,i+"+",i,n-i,n);
		}
		return res;
	}
	
	private void addSolution_(List<String> res, String curr, int former, int left, int n){
		res.add(new String(curr+left));
		if(left > former * 2){ //可以继续分解
			for(int i = former; left - i >= i; i ++){
				addSolution_(res,curr+i+"+",i,left - i,n);
			}
		}
		else if(left == former * 2){
			res.add(new String(curr+former+"+"+former));
		}
	}
	
	public void wiggleSortII(int[] nums){
		if (nums == null || nums.length <= 1) return;
        int median = getMedian(nums); //找到中位数的同时，将原来的数组按照 高 中 低 的顺序排序
 
        int higher = 0, lower = nums.length - 1, current = 0;
        //TODO 下面这段代码是啥意思？
        while (current <= lower) {
            if (nums[reIndex(current, nums.length)] == median) { 
                current++;
            }
 
            else if (nums[reIndex(current, nums.length)] < median) {
                swap(nums, reIndex(current, nums.length), reIndex(lower--, nums.length));
            }
            else swap(nums, reIndex(current++, nums.length), reIndex(higher++, nums.length));
        }
	}
	private int reIndex(int index, int n) {
        return (2*index + 1) % (n | 1); //如果n为偶数，则n|1=n+1。
    }
 
    private int getMedian(int[] nums) {
        int start = 0, end = nums.length - 1, target = nums.length / 2;
        while (true) {
            swap(nums, start, (start + end) / 2);
            int swapIndex = start, current = start + 1;
            while (current <= end) {
                if (nums[current] >= nums[start]) swap(nums, ++swapIndex, current);
                current++;
            }
            swap(nums, start, swapIndex);
            if (swapIndex - start == target) return nums[swapIndex];
            else if (swapIndex - start > target) end = swapIndex - 1;
            else {
                target -= (swapIndex - start + 1);
                start = swapIndex + 1;
            }
        }
    }
 
	//解决的是可取等的情况。
	public void wiggleSort(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        int k = nums.length/2;
        for(int i = 0; i < k; i++){
        	if((2*i+1)<nums.length && nums[2*i] > nums[2*i+1]) swap(nums,2*i,2*i+1);
        	if((2*i+2)<nums.length && nums[2*i+1] < nums[2*i+2]) swap(nums,2*i+1,2*i+2);
        }
    }
	
	public void swap(int[] nums,int a,int b){
		int temp = nums[a];
		nums[a]=nums[b];
		nums[b]=temp;
	}
}
