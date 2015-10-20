package com.sky.leetcode;

/*
 * [
[-9,-7,-7,-7,-6,-6,-6,-4,-3,-1,0],
[3,5,6,8,8,10,12,14,14,16,17],
[20,22,23,23,23,23,25,25,27,28,28],
[29,31,33,33,35,37,37,39,39,41,42],
[43,45,46,48,49,50,50,51,51,53,53],
[56,57,58,58,58,58,58,60,61,62,64],
[65,67,68,70,72,74,74,76,76,76,77],
[78,79,79,80,81,82,83,85,87,89,90],
[92,94,96,98,99,100,100,102,102,103,105],
[106,106,106,108,109,111,113,115,117,119,120],
[123,124,126,128,128,130,131,131,132,132,133],
[134,136,138,140,140,142,144,145,146,148,150],
[152,153,154,156,158,159,161,163,165,166,167],
[170,171,173,173,173,173,174,175,176,178,180],
[181,182,184,186,187,189,191,193,195,196,196]]
//10
 * */
public class _074_Search2DMatrix_1{
	public static void main(String args[]){
		
		int nums[]={1,3,5,7,9,11,13,17,19,21};
		for(int i=0;i<20;i++)
			System.out.println(2*i+":"+binarySearch(nums,2*i));
		int[][] matrix={{1},{3},{5}};
		int target=3;
		System.out.println(searchMatrix0(matrix,target));
	}
	
	/*
	 * binary search return the position that the target should put in.
	 * It is not correct!
	 * When the target is much larger than the biggest of the nums array, it will
	 * return the last position of the array. Obviously it's not right!
	 */
	public static int binarySearch(int[] nums,int target){
		int low=0;
		int high=nums.length-1;
		while(low<high){
			int mid=(low+high)/2;
			if(nums[mid]<target)
				low=mid+1;
			else
				high=mid;
		}
		return low;
	}
	
	public static boolean searchMatrix0(int[][] matrix,int target){
		int x=matrix.length;
		if(x==0)
			return false;
		int y=matrix[0].length;
		int size=x*y;
		int low=0;int high=size-1;int mid=0; int temp=0;
		while(low<=high){
			mid=(low+high)/2;
			temp=matrix[mid/y][mid%y];
			if(temp==target)
				return true;
			else if(temp<target)
				low=mid+1;
			else
				high=mid-1;
		}
		return false;	
	}
	
	public static boolean searchMatrix(int[][] matrix, int target) {
		int x=matrix.length;
		if(x==0)
			return false;
		int y=matrix[0].length;
		int low=0;
		int high=x-1;
		int mid=0;
		/*
		 * The block below is not correct when it didn't find the target.
		 * It couldn't return the right position that the target should put in.
		 */
//		while(low<=high){
//			mid=(low+high)/2;
//			if(matrix[mid][0]==target)
//				return true;
//			else if(matrix[mid][0]<target)
//				low=mid+1;
//			else
//				high=mid-1;
//		}
		while(low<high){
			mid=(low+high)/2;
			if(matrix[mid][0]<target)
				low=mid+1;
			else
				high=mid;
		}
		//tip: don't forget to check if its the target first!
		if(matrix[low][0]==target)
		    return true;
		int get_x=0;
		if(low==0)
			get_x=0;
		else if(low==x-1)
			if(matrix[low][0]<target)
				get_x=low;
			else
				get_x=low-1;
		else
			get_x=low-1;
		low=0;
		high=y-1;
		while(low<=high){
			mid=(low+high)/2;
			if(matrix[get_x][mid]==target)
				return true;
			else if(matrix[get_x][mid]<target)
				low=mid+1;
			else
				high=mid-1;
		}
		return false;
	}
}
