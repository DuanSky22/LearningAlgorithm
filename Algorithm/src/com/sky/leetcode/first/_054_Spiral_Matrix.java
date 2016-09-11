package com.sky.leetcode.first;

import java.util.ArrayList;
import java.util.List;

public class _054_Spiral_Matrix {
	
	public static void main(String args[]){
		_054_Spiral_Matrix test = new _054_Spiral_Matrix();
		int[][] matrix = {
				{1},
				{2},
				{3}
		};
		System.out.println(test.spiralOrder(matrix));
	}
	public List<Integer> spiralOrder(int[][] matrix) {
		if(matrix == null || matrix.length == 0) return new ArrayList<>();
        int k = 0, m = matrix.length, n = matrix[0].length; 
        List<Integer> list = new ArrayList<>(m * n);
        while( k <= Math.min(m, n)/2){
        	if(k > n - 1 - k) break;
        	for(int i = k; i <= n - 1 - k; i++)
        		list.add(matrix[k][i]);
        	if(k + 1 > m - 1 - k) break;
        	for(int j = k + 1; j <= m - 1 - k; j++)
        		list.add(matrix[j][n-1-k]);
        	if(n - 1 - k - 1 < k) break;
        	for(int i = n - 1 - k - 1; i >= k; i--)
        		list.add(matrix[m-1-k][i]);
        	if(m - 1 - k - 1 == k) break;
        	for(int j = m - 1 - k - 1; j > k; j--)
        		list.add(matrix[j][k]);
        	k++;
        }
        return list;
    }
}
