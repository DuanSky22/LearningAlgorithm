package com.sky.leetcode.first;
/**
 * @author DuanSky
 * @date 2015年12月28日 下午4:19:22
 * @content 
 */

public class _063_Unique_PathsII {
	
	public static void main(String args[]){
		System.out.println(uniquePathsWithObstacles(new int[][]{{0}}));
	}
	
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null || obstacleGrid.length==0 || obstacleGrid[0].length==0) return 0;
        int m=obstacleGrid.length; int n=obstacleGrid[0].length;
        int[][] d=new int[m][n];
        d[0][0] = obstacleGrid[0][0]==0 ? 1 : 0;
        for(int i=1;i<m;i++) 
        	d[i][0] = ((d[i-1][0] & ~obstacleGrid[i][0]) == 1) ? 1 : 0; //只有在前面为1，且本位不是障碍物时，才能取值为1.
        for(int j=1;j<n;j++)
        	d[0][j] = ((d[0][j-1] & ~obstacleGrid[0][j]) == 1) ? 1 : 0;
        for(int i=1;i<m;i++)
        	for(int j=1;j<n;j++)
        		d[i][j]= obstacleGrid[i][j]==1 ? 0 : d[i-1][j]+d[i][j-1];
        return d[m-1][n-1];
    }
}
