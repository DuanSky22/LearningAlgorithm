package com.sky.topic.sort;
/**
 * @author DuanSky
 * @date 2016年3月8日 下午2:10:33
 * @content 
 */

public class _02_Sort_Algorithm {

	public static void main(String args[]){
		_02_Sort_Algorithm test = new _02_Sort_Algorithm();
		int[] nums = {1,3,2,4,6,5,8};
		test.heapSort(nums);
	}
	
	//堆排序
	public void heapSort(int nums[]){
		if(nums==null || nums.length<2) return;
		buildMaxHeap(nums);
		for(int i=nums.length-1;i>0;i--){
			swap(nums,0,i);
			maxHeapify(nums,0,i);
		}
	}
	//自底向上的创建大顶堆
	private void buildMaxHeap(int[] nums){
		int length = nums.length;
		for(int i = (length - 1)/2; i >= 0; i --){
			maxHeapify(nums,i,length);
		}
	}
	//保证数组是以k为节点的大顶堆,在调整之前先假设了k节点的两个孩子节点都已经是大顶推。
	private void maxHeapify(int[] nums,int k,int length){
		int largest = k, left = 2 * k + 1, right = 2 * k + 2;
		if(left < length && nums[left] > nums[k])
			largest = left;
		if(right < length && nums[right] > nums[largest])
			largest = right;
		if(largest != k){
			swap(nums,k,largest);
			maxHeapify(nums,largest,length);
		}
	}

	private void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}
