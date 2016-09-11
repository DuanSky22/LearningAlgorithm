package com.sky.leetcode.first;
/**
 * @author DuanSky
 * @date 2016年3月8日 下午2:55:10
 * @content 
 */

public class _215_Kth_Largest_Element_in_an_Array {
	
	public static void main(String args[]){
		_215_Kth_Largest_Element_in_an_Array test = new _215_Kth_Largest_Element_in_an_Array();
		int[] nums = {-1,2,0};
		int k = 1;
		System.out.println(test.solution_1(nums, k));
		System.out.println(test.solution_2(nums, k));
	}
	
	public int solution_2(int[] nums,int k){
		//建立一个 有K个元素组成的小顶堆
		bulidMinHeap(nums,k);
		//不断的更新堆中元素
		for(int i = k + 1; i < nums.length; i++){
			if(nums[i] > nums[0]){
				swap(nums,0,i);
				minHeapify(nums,k,0);
			}
		}
		return nums[0];
	}
	
	private void bulidMinHeap(int[] nums, int length){
		for(int i = (length-1)/2; i>=0; i--)
			minHeapify(nums,length,i);
	}
	
	private void minHeapify(int[] nums, int length, int k){
		int smallest = k, left = 2 * k + 1, right = 2 * k + 2;
		if(left<length && nums[left] < nums[smallest])
			smallest = left;
		if(right<length && nums[right] < nums[smallest])
			smallest = right;
		if(smallest != k){
			swap(nums,smallest,k);
			minHeapify(nums,length,smallest);
		}
	}
	
	//binary search[start,end)
	public int solution_1(int[] nums,int k){
		return solution_1_(nums,0,nums.length,k);
	}
	private int solution_1_(int[] nums,int start,int end,int k){
		int pivot = nums[start],cutPos = end;
		for(int i = start+1; i < cutPos; i ++){
			if(nums[i] < pivot){//如果当前的元素比支点小，则需要移动到末尾
				swap(nums,i--,--cutPos);
			}
		}
		swap(nums,start,cutPos-1);
		if(cutPos - start == k) return pivot;
		else if(cutPos - start < k) return solution_1_(nums,cutPos,end,k-(cutPos - start));
		else return solution_1_(nums,start,cutPos-1,k);
	}
	
	private void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
	
}
