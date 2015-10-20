/**
* @author DuanSky
* @date 2015年10月20日 下午10:01:10
* @content 
*/
package com.sky.leetcode;

public class _240_Searcha2DMatrixII_1 {
	
	public boolean searchMatrix0(int[][] matrix,int target){
		int x=matrix.length;
		if(x<0)
			return false;
		int y=matrix[0].length;
		int current_x=x-1;
		int current_y=0;
		while(current_x>=0 && current_y<y){
			if(target==matrix[current_x][current_y])
				return true;
			else if(target>matrix[current_x][current_y])
				current_y++;
			else
				current_x--;
		}
		return false;
	}
	/*
	 * below I want to use binary search on row and col but failed.
	 */
	 public boolean searchMatrix(int[][] matrix, int target) {
		 int x=matrix.length;
		 if(x==0)
			 return false;
		 int y=matrix[0].length;
		 int x_low=0;int x_high=x-1;
		 int y_low=0;int y_high=y-1;
		 while(x_low<=x_high && y_low<=y_high){
			 
		 }
		 
		 return true;
	 }
}
