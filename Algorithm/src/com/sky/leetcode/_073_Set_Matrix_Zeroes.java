package com.sky.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _073_Set_Matrix_Zeroes {
	
	
	
	public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;
        Set<Integer> h = new HashSet<Integer>();
        Set<Integer> w = new HashSet<Integer>();
        for(int i =0 ; i < matrix.length; i++){
        	for(int j = 0; j < matrix[0].length; j++){
        		if(matrix[i][j] == 0){
        			h.add(i);
        			w.add(j);
        		}
        	}
        }
        for( int x : h)
        	for(int j = 0; j < matrix[0].length; j++)
        		matrix[x][j] = 0;
        for(int y : w)
        	for(int i = 0; i < matrix.length; i++)
        		matrix[i][y] = 0;
    }
}
