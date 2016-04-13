package com.sky.leetcode;

public class _059_Spiral_Matrix_II {
	
	public static void main(String args[]){
		int[][] matrix = new _059_Spiral_Matrix_II().generateMatrix(2);
	}
	
	public int[][] generateMatrix(int n) {
        int k = 0,counter = 1; 
        int[][] matrix = new int[n][n];
        while(2 * k <= n){
        	for(int i = k; i <= n - 1 - k; i++)
        		matrix[k][i] = counter++;
        	for(int j = k+1; j < n - 1 - k; j++)
        		matrix[j][n-1-k] = counter++;
        	for(int i = n - 1 - k; i > k; i--)
        		matrix[n-1-k][i] = counter++;
        	for(int j = n - 1 - k; j > k; j--)
        		matrix[j][k] =  counter++;
        	k++;
        }
        return matrix;
    }
}
