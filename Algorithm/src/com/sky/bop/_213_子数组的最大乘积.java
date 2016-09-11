package com.sky.bop;
/**
 * @author DuanSky
 * @date 2016年5月4日 下午3:19:18
 * @content 
 */

public class _213_子数组的最大乘积 {
	
	public static void main(String args[]){
		int[] nums = { -1,2,3,4,-2,9};
		_213_子数组的最大乘积 test = new _213_子数组的最大乘积();
		System.out.println(test.maxProduct(nums)+":"+test.maxProduct1(nums));
	}
	
	public int maxProduct(int[] nums){
		if(nums == null || nums.length == 0) return Integer.MIN_VALUE;
		int n = nums.length,res = Integer.MIN_VALUE;
		int[] left = new int[n], right = new int[n];//left[k] 表示从a[0]*...a[k-1]的积，right[k]表示从a[k]*...a[n-1]的积
		for(int i = 0; i < n; i++){
			left[i] = 1; right[i] = 1;
		}
		for(int k = 0; k < n; k++){
			for(int j = 0; j < k; j++) left[k]*=nums[j];
			for(int i = k+1; i < n; i++) right[k]*=nums[i];
		}
		for(int k = 0; k < n; k++)
			res = Math.max(res, left[k]*right[k]);
		return res;
	}
	
	public int maxProduct1(int[] nums){
		int zeroCount = 0,  negativeCount = 0;
		int maxNegative = Integer.MIN_VALUE, maxNegaPos = -1, minPositive = Integer.MAX_VALUE, minPosiPos = -1, zeroPos = -1;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] == 0) {
				zeroCount++;
				zeroPos = i;
			}
			else if(nums[i] > 0){
				if(nums[i] <= minPositive){
					minPositive = nums[i];
					minPosiPos = i;
				}
			}else{
				negativeCount++;
				if(nums[i] >= maxNegative){
					maxNegative = nums[i];
					maxNegaPos = i;
				}
			}
		}
		if(zeroCount >= 2 || (zeroCount == 1 && negativeCount % 2 == 1)) return 0;
		else if(zeroCount == 1){
			return productExceptOne(nums,zeroPos);
		}else{
			if(negativeCount % 2 == 1)//负数的数目为奇数，得去掉一个负数
				return productExceptOne(nums,maxNegaPos);
			else//负数的数目为偶数,则只能去掉最小正数
				return productExceptOne(nums,minPosiPos);
		}
	}
	
	public int productExceptOne(int[] nums,int pos){
		int res = 1;
		for(int i = 0; i < nums.length; i++){
			if(i != pos) res *= nums[i];
		}
		return res;
	}
}
