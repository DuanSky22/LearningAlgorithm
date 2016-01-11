package com.sky.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author DuanSky
 * @date 2016年1月6日 上午9:34:19
 * @content 
 */

public class _130_Surrounded_Regions {
	
	public static void main(String args[]){
		char[][] board=new char[][]{
				{'X', 'X', 'X', 'X'},
				{'X' ,'O', 'O' ,'X'},
				{'X' ,'X' ,'O' ,'X'},
				{'X' ,'O', 'X', 'X'}};
		solve(board);
	}
	
	public static void solve(char[][] board) {
		if(board==null || board.length<=1 || board[0].length<=1) return;
        int m=board.length, n=board[0].length;
        boolean result[][]=new boolean[m][n];
        for(int i=0;i<n;i++){
        	if(board[0][i]=='O'  ) calculate(board,result,new int[]{0,i});
        	if(board[m-1][i]=='O') calculate(board,result,new int[]{m-1,i});
        }
        for(int j=0;j<m;j++){
        	if(board[j][0]=='O') calculate(board,result,new int[]{j,0});
        	if(board[j][n-1]=='O') calculate(board,result,new int[]{j,n-1});
        }
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		if(board[i][j]=='O' && result[i][j]==false)
        			board[i][j]='X';
        	}
        }
    }
	
	public static void calculate(char[][] board,boolean[][] result,int[] seed){

		Queue<int[]> queue = new LinkedList<>();
		queue.add(seed);
		result[seed[0]][seed[1]]=true;
		while(!queue.isEmpty()){
			int[] elem=queue.poll();
			int x=elem[0], y=elem[1];
			
			int[][] arrays=new int[4][2];
			arrays[0][0]=x-1; arrays[0][1]=y;
			arrays[1][0]=x+1; arrays[1][1]=y;
			arrays[2][0]=x; arrays[2][1]=y-1;
			arrays[3][0]=x; arrays[3][1]=y+1;
			
			for(int i=0;i<arrays.length;i++){
				if(arrays[i][0]>=0 && arrays[i][0]<result.length && 
						arrays[i][1]>=0 && arrays[i][1]<result[0].length && 
						board[arrays[i][0]][arrays[i][1]]=='O' && result[arrays[i][0]][arrays[i][1]]!=true){
					result[arrays[i][0]][arrays[i][1]]=true;
					queue.add(new int[]{arrays[i][0],arrays[i][1]});
				}
			}
		}
	}
	
	//MISTAKE 如果采用递归则会出现Stack Overflow.改写成非递归的形式
	public static void isAdj(char[][] board,boolean[][] result,int[] seed){
		int x=seed[0], y=seed[1];
		if(x>=0 && x<result.length && 
				y>=0 && y<result[0].length && 
				board[x][y]=='O' &&result[x][y]!=true){
			result[x][y]=true;
			isAdj(board,result,new int[]{x+1,y});
			isAdj(board,result,new int[]{x,y+1});
			isAdj(board,result,new int[]{x-1,y});
			isAdj(board,result,new int[]{x,y-1});
		}
	}
}
