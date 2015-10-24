/**
* @author DuanSky
* @date 2015年10月19日 下午12:19:15
* @content 
*/
package com.sky.leetcode;

public class _278_FirstBadVersion {
	
	public static int T=1702766719;
	
	public static void main(String args[]){
//		for(int low=0;low<1000;low++){
//			for(int high=low;high<1000;high++){
//				if(low+(high-low)/2 != (low+high)/2)
//					System.out.println(low+(high-low)/2 +":"+ (low+high)/2);
//			}
//		}
		for(int k=1702766719+100;k<2126753390;k++)
			System.out.println(firstBadVersion(k));
	}

	//binary search method can also use to divide two different part.
	/*
	 * Here we specifically be care for the condition of the while circle and 
	 * the change of every step.
	 * 
	 * Another detail we should be care of is that we use 
	 *  mid=left + (right-left)/2 to change middle
	 * instead of 
	 *  mid=(left + right)/2 
	 * for the sake of the overflow. 
	 */
	public static int firstBadVersion(int n) {
		int left = 1;
        int right = n;
        int mid;
        while(left < right) { //be careful
            mid = left+(right - left) / 2; 
            if(isBadVersion(mid)) {
                right = mid; //be careful
            }
            else {
                left = mid+1; //be careful
            }
        }
        return left;
    }
	
	public int binarySearch(int[] nums,int target){
		int low=0;
		int high=nums.length-1;
		while(low<high){
			int mid=(low+high)/2;
			if(nums[mid]<target)
				high=mid;
			else
				low=mid+1;
		}
		if(nums[low]==target)
			return low;
		if(low==0)
			return 0;
		return nums[low]-target>target-nums[low-1] ? low-1 : low;
	}
	
	public static boolean isBadVersion(int k){
		if(k<T)
			return false;
		else
			return true;
	}
}
