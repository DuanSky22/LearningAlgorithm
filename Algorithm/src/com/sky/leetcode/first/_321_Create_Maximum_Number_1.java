package com.sky.leetcode.first;
/**
 * @author DuanSky
 * @date 2016年3月11日 下午4:47:12
 * @content 
 */

public class _321_Create_Maximum_Number_1 {
	
	public static void main(String args[]){
		_321_Create_Maximum_Number_1 test = new _321_Create_Maximum_Number_1();
		int[] nums = new int[]{9,1,2,5,8,3};
//		int k =1;
//		int[] res = test.solution(nums, k);
		
		int[] nums1 = new int[]{8, 9};
		int[] nums2 = new int[]{3, 9};
		int k = 5;
		int[] res = test.maxArray(nums, k);
	}

	//MISTAKE 思路有问题，无法处理 出现相等的情况
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k]; 
        int i = 0, j = 0, max = -1,pos = 0, curr = 0,flag = 0;
        int n1 = nums1.length-1, n2 = nums2.length-1; // i is the pointer of the nums1, j is the pointer of the nums2.
        while( curr < k ){          // 末尾至少保留 k - curr - 1 个元素
        	int left1 = n1 - i + 1; //n1剩余的元素
        	int left2 = n2 - j + 1; //n2 剩余的元素
        	int left = k - curr - 1; //末尾至少要留left个元素
        	int f1 = left2 < left ?  (n1 - (left - left2)) : n1;
        	int f2 = left1< left ?  (n2 - (left - left1)) : n2 ;
    		for(int t = i; t <= f1; t ++){
    			if(nums1[t] > max){
    				max = nums1[t];
    				pos = t;
    				flag = 1;
    			}
    			if(max==9) 
    				break;
    		}
    		
    		for(int t = j; t <= f2; t ++){
    			if(nums2[t] > max){
    				max = nums2[t];
    				pos = t;
    				flag = 2;
    			}
    			if(max==9) 
    				break;
    		}
    		res[curr]=max;
			max = -1;
			curr ++;
			if(flag==1) i = pos + 1;
			else j = pos + 1;
        }
        return res;
    }
	
	//引申问题： 从一个N位正整数中不改变元素顺序的挑选出K个数组成一个最大的新的整数。
	public int[] solution(int[] nums, int k){
		if(nums == null || nums.length == 0 || k >= nums.length) return nums; 
		int[] res = new int[k];
		int i = 0, j = k,pos = -1, max = 0;//j 指定了当前要找的那个位置上的数
		while(i<nums.length && j > 0){
			for(int t = i; t <= nums.length - j; t++){//j = 1, 后面留了一个元素
				if(nums[t] > max) { 
					max = nums[t]; 
					pos = t;
				}
				if(max == 9){
					break;
				}
			}
			res[k-j] = max;
			i = pos + 1;
			j--;
			max = -1;
		}
		
		return res;
	}
	
	//引申问题的标准解法
	public int[] maxArray(int[] nums, int k) {
	    int n = nums.length;
	    int[] ans = new int[k];
	    for (int i = 0, j = 0; i < n; ++i) {
	        while (n - i + j > k && j > 0 && ans[j - 1] < nums[i]) 
	        	j--;
	        if (j < k) 
	        	ans[j++] = nums[i];
	    }
	    return ans;
	}
}
