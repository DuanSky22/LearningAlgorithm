package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2016年3月2日 上午11:21:41
 * @content 
 */

public class _329_Longest_Increasing_Path_in_a_Matrix {
	
	public static void main(String args[]){
		_329_Longest_Increasing_Path_in_a_Matrix test = new _329_Longest_Increasing_Path_in_a_Matrix();
		int[][] matrix = {
				{9,9,4},
				{6,6,8},
				{2,1,1}
		};
		System.out.println(test.longestIncreasingPath(matrix));
	}
	
	public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0) return 0;
		int max = 0, res[][]=new int[matrix.length][matrix[0].length];
		for(int i=0;i<matrix.length;i++)
			for(int j=0;j<matrix[0].length;j++)
				res[i][j]=-1;
        for(int i=0;i<matrix.length;i++)
        	for(int j=0;j<matrix[0].length;j++)
        		max = Math.max(solution(matrix,new int[]{i,j},res),max);
        return max;
    }
	
	private int solution(int[][] matrix,int[] curr,int[][] res){
		int x = curr[0], y = curr[1];
		if(x<0 || x>=matrix.length || //out of the range.
				y<0 || y>=matrix[0].length) return 0;
		int left = 0, right = 0, up = 0, down = 0;
		if(x>0 && matrix[x][y]<matrix[x-1][y]) up = res[x-1][y]== -1 ? solution(matrix,new int[]{x-1,y},res) : res[x-1][y];
		if(x<matrix.length-1 && matrix[x][y]<matrix[x+1][y]) down = res[x+1][y]== -1 ? solution(matrix,new int[]{x+1,y},res) : res[x+1][y];
		if(y>0 && matrix[x][y]<matrix[x][y-1]) left = res[x][y-1]== -1 ? solution(matrix,new int[]{x,y-1},res) : res[x][y-1];
		if(y<matrix[0].length-1 && matrix[x][y]<matrix[x][y+1]) right = res[x][y+1] == -1 ? solution(matrix,new int[]{x,y+1},res) : res[x][y+1];
		res[x][y] =Math.max(Math.max(Math.max(left, right), up), down)+1;
		return res[x][y];
		
	}

}
