package com.sky.bop;

public class _210_寻找数组中的最大值和最小值 {
	
	public static void main(String args[]){
		_210_寻找数组中的最大值和最小值 test = new _210_寻找数组中的最大值和最小值();
		int[] nums = {1,2,3,45,2,12,14,56};
		int[] res1 = test.findMaxMin0(nums);
		int[] res2 = test.findMaxMin1(nums);
		int[] res3 = test.findMaxMin2(nums);
	}
	
	//需要遍历比较两遍所有的元素
	public int[] findMaxMin0(int[] nums){
		if(nums.length == 1) return new int[]{nums[0],nums[0]};
		int currMax = Math.max(nums[0], nums[1]), currMin = Math.min(nums[0], nums[1]);
		for(int i = 2; i < nums.length; i++){
			if(nums[i] > currMax)
				currMax = nums[i];
			else if(nums[i] < currMin)
				currMin = nums[i];
		}
		return new int[]{currMin,currMax};
	}
	
	//每两个两个进行比较
	public int[] findMaxMin1(int[] nums){
		int[] res = new int[2];
		if(nums.length == 1){
			res[0] = nums[0];
			res[1] = nums[0];
		}else{
			res[0] = Math.min(nums[0], nums[1]);
			res[1] = Math.max(nums[0], nums[1]);
			for(int i = 2; i < nums.length; i+=2){
				if(i+1 != nums.length){
					if(nums[i] < nums[i+1]){
						res[0] = Math.min(res[0], nums[i]);
						res[1] = Math.max(res[1], nums[i+1]);
					}
					else{
						res[1] = Math.min(res[1], nums[i]);
						res[1] = Math.max(res[1], nums[i+1]);	
					}
				}else{
					res[0] = Math.min(res[0], nums[i]);
					res[1] = Math.max(res[1], nums[i]);
				}
			}
		}
		return res;
	}
	
	public int[] findMaxMin2(int[] nums){
		if(nums == null || nums.length == 0) return new int[]{};
		if(nums.length == 1) return new int[]{nums[0],nums[1]};
		return divide(nums,0,nums.length-1);
	}

	private int[] divide(int[] nums, int start, int end) {
		if(start + 1 == end || start == end){
			if(nums[start] <= nums[end]) return new int[]{nums[start],nums[end]};
			else return new int[]{nums[end],nums[start]};
		}
		else{
			int middle = (start + end) / 2;
			int[] left = divide(nums,start,middle);
			int[] right = divide(nums,middle+1,end);
			return new int[]{Math.min(left[0], right[0]),Math.max(left[1], right[1])};
		}
	}
}
