package com.sky.topic;
/**
 * @author DuanSky
 * @date 2016年3月8日 上午10:11:10
 * @content 
 */

public class _02_Sort_find_top_K_max_in_array {
	
	public static void main(String args[]){
		_02_Sort_find_top_K_max_in_array test = new _02_Sort_find_top_K_max_in_array();
		int[] nums = {1,3,2,5,4,7,6};
		int k =5;
		int[] res = test.solution_1(nums, k);
	}
	
	public int[] solution_1(int[] nums,int k){
		if(nums.length<=k) return nums;
		solution_(nums,0,nums.length,k);
		int[] res = new int[k];
		for(int i=0;i<res.length;i++)
			res[i]=nums[i];
		return res;
	}
	//在[start,end)范围内找最大的k个数
	private void solution_(int[] nums,int start,int end,int k){
		int pivot = nums[start], cut = end;
		for(int i=start; i < cut; i ++){
			if(nums[i] < pivot){//比支点小的元素要移动到尾部
				swap(nums,i--,--cut); //MISTAKE 特别需要注意的是i指针的位置需要复位！
			}
		}
		swap(nums,start,cut-1);
		int leftLength = cut - start;
		if(leftLength == k) return;
		else if(leftLength > k) solution_(nums,start,cut-1,k);
		else solution_(nums,cut,end,k-leftLength);
		
	}
	
	private void swap(int[] nums,int a,int b){
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

}
