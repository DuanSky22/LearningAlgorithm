package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2016年1月7日 下午2:36:21
 * @content 
 */

public class _48_Rotate_Image {
	
	public static void main(String args[]){	
		int[][] matrix={{1,2},{3,4}};
		rotate_(matrix);
	}
	
	public static void rotate(int[][] matrix) {
        if(matrix == null || matrix.length==0 || matrix[0].length==0) return;
        int m=matrix.length, n=matrix[0].length;
        int[][] result=new int[n][m];
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		result[j][m-i-1]=matrix[i][j];
        	}
        }
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		matrix[i][j]=result[i][j];
        	}
        }
    }
	
	public static void rotate_(int[][] matrix){
		 if(matrix == null || matrix.length==0 || matrix[0].length==0) return;
		 int m=matrix.length, n=matrix[0].length;
		 for(int i=0;i<m;i++)
			 for(int j=i;j<n;j++)
				 swap(matrix,new int[]{i,j},new int[]{j,i});
		 for(int i=0;i<m;i++)
			 for(int j=0;j<n/2;j++)
				 swap(matrix,new int[]{i,j},new int[]{i,n-1-j});
	}
	
	public static void swap(int[][] matrix,int[] a,int[] b){
		int temp=matrix[a[0]][a[1]];
		matrix[a[0]][a[1]]=matrix[b[0]][b[1]];
		matrix[b[0]][b[1]]=temp;
	}
	

}
