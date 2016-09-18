package com.sky.company.baidu;

/**
 * Created by DuanSky on 2016/9/13.
 */
public class Solution1 {

    public static void main(String args[]){
        int[][] grid = {{0,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,0}};
        System.out.println(countHomes(grid));
    }

    public static int countHomes(int grid[][]){
        if(grid == null) return 0;
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    count++;
                    changeFlags(grid,i,j);
                }
            }
        }
        return count;
    }

    public static void changeFlags(int grid[][],int i,int j){
        if(i == grid.length || j == grid[0].length) return;
        grid[i][j] = 0;
        if(grid[i+1][j] == 1) changeFlags(grid,i+1,j);
        if(grid[i][j+1] == 1) changeFlags(grid,i,j+1);
    }
}
