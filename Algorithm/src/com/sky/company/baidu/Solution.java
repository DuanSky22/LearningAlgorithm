package com.sky.company.baidu;

/**
 * Created by DuanSky on 2016/9/13.
 */
public class Solution {

    public static void main(String args[]){
        int[][] res = transposeMultiMatrix(3,4,2);
        int k = 0;
    }

    public static int[][] transposeMultiMatrix(int initialValue,int rows,int columns){
        int[][] data = new int[rows][columns];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                data[i][j] = initialValue++;
            }
        }
        int[][] transpose = transpose(data);
        return multiMatrix(data,transpose);
    }

    public static int[][] transpose(int[][] data){
        int rows = data.length, columns = data[0].length;
        int[][] res = new int[columns][rows];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                res[j][i] = data[i][j];
            }
        }
        return res;
    }

    public static int[][] multiMatrix(int[][] first,int[][] second){
        int firstRows = first.length, firstColumns = first[0].length;
        int secondRows = second.length, secondColumns = second[0].length;
        int [][] res = new int[firstRows][secondColumns];
        for(int i = 0; i < res.length; i++){
            for(int j = 0; j < res[0].length; j++){
                for(int k = 0; k < firstColumns; k++)
                    res[i][j] += first[i][k] * second[k][j];
            }
        }
        return res;
    }
}
