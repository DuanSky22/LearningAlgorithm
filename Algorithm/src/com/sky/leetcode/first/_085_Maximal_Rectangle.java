package com.sky.leetcode.first;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DuanSky
 * @date 2016年3月21日 下午10:46:28
 * @content 
 */

public class _085_Maximal_Rectangle {
	public static void main(String args[]){
		int n = 3;
		int left = 1;
		while(n > 1){
			n --;
			if(n%2==0) left = (left + 1) *2;
			else left = (left + 3)*2;
		}
		System.out.println(left);
	}
	
	public int maximalRectangle(char[][] matrix) {
        return 0;
    }
	
	public List<int[]> change(char[][] matrix){
		List<int[]> res = new ArrayList<>();
		int m = matrix.length, n =matrix[0].length;
		for(int i = 0; i < m; i++){
			int start = -1, end = -1;
			for(int j = 0; j < n; j++){
				if(start == -1 && matrix[i][j]=='1')
					start = j;
			}
		}
		
		return res;
	}

}
