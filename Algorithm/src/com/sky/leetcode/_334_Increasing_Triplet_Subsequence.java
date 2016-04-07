package com.sky.leetcode;

public class _334_Increasing_Triplet_Subsequence {
	 public boolean increasingTriplet(int[] nums) {
		 if(nums != null && nums.length >= 3){
			 /*
			  *  c1 means the minimum value of the arrays by now
			  *  c2 means the second minimum value of the array by now.
			  *  We just test if the current value is smaller than c1 or c2. 
			  */
			 int c1 = Integer.MAX_VALUE, c2 = Integer.MAX_VALUE;
			 for(int num : nums){
				 if( num <= c1) c1 = num; //if the num is smaller the c1, then update c1.
				 else if( num <= c2) c2 = num; //if the num is larger than c1 and smaller than c2, then update c2.
				 else return true; //by now ,we have find c1 ,c2 and c1 is smaller than c2, and the current number is larger than c2
			 }
		 }
		 return false;
	 }
	 
	 public boolean increasingKSubsequence(int[] nums,int k){
		 if(k > 0 && nums != null && nums.length >= k){
			 int res[] = new int[k];
			 for(int i = 0; i < k; i++) res[i] = Integer.MAX_VALUE;
			 for(int num : nums){
				 int j = 0;
		        //以下这个部分可以换成二分搜索来加速
				 for(; j < k; j++){
					 if(num <= res[j]){
						 res[j] = num;
						 break;
					 }
				 }
				 if(j == k-1) return true;
			 }
		 }
		 return false;
	 }
}
