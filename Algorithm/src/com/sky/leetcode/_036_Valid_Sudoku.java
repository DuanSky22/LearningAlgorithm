package com.sky.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
 * char[][] board = {
				{'.','8','7','6','5','4','3','2','1'},
				{'2','.','.','.','.','.','.','.','.'},
				{'3','.','.','.','.','.','.','.','.'},
				{'4','.','.','.','.','.','.','.','.'},
				{'5','.','.','.','.','.','.','.','.'},
				{'6','.','.','.','.','.','.','.','.'},
				{'7','.','.','.','.','.','.','.','.'},
				{'8','.','.','.','.','.','.','.','.'},
				{'9','.','.','.','.','.','.','.','.'}
		};
 */
public class _036_Valid_Sudoku {
	

	public static void main(String args[]){
		String s = "[..4...63.,.........,5......9.,...56....,4.3.....1,...7.....,...5.....,.........,.........]";
		char[][] board = getBoard(s);
		_036_Valid_Sudoku test = new _036_Valid_Sudoku();
		System.out.println(test.isValidSudoku0(board));
	}
	
	private static final int BASE = 3;
	private static final int N = BASE * BASE;
	
	
	public boolean isValidSudoku0(char[][] board) {
        int n = board.length;
        for(int k = 0; k < n; k++){ //第k行或者第k列是否存在重复的
        	Set<Character> set = new HashSet<Character>();
        	for(int i = 0; i < n; i++){
        		char c = board[k][i];
        		if(c != '.'){
        			if(set.contains(c)) return false;
        			set.add(c);
        		}
        	}
        	set.clear();
        	for(int j = 0; j < n; j++){
        		char c = board[j][k];
        		if(c != '.'){
        			if(set.contains(c)) return false;
        			set.add(c);
        		}
        	}
        }
        for(int i = 0; i < 3; i++){
        	for(int j = 0; j < 3; j++){
        		Set<Character> set = new HashSet<Character>();
        		for(int t = 0; t < 9; t++){
        			char c = board[i * 3 + t / 3][j * 3 + t % 3];
        			if(c != '.'){
        				if(set.contains(c)) return false;
        				set.add(c);
        			}
        		}
        	}
        }
        return true;
    }
	
	public static char[][] getBoard(String s){
		char[][] board = new char[N][N]; int counter = 0;
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(c == ',' || c == '[' || c ==']') continue;
			int m = counter / 9;
			int n = counter % 9;
			board[m][n] = c;
			counter++;
		}
		return board;
	}
	
	public boolean isValidSudoku(char[][] board) {
       for(int i = 0; i < N; i++){
    	   for(int j = 0; j < N; j++){
    		   if(board[i][j] == '.'){
    			   Set<Integer> candidates = getCandidates(i,j,board);
    			   if(candidates.isEmpty()) return false;
    			   for(Integer candidate : candidates){
    				   board[i][j] = (char) (candidate + '0'); //填写当前的值
    				   if(isValidSudoku(board)){//判断填写之后是否满足,如果满足就填写
    					   continue;
    				   }
    				   board[i][j] = '.'; //不满足则回复原来样子
    			   }
    		   }
    	   }
       } 
       return true;
    }
	
	public Set<Integer> getCandidates(int x,int y,char[][] board){
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 1; i <= N; i++) set.add(i);
		//check left to right and up to down.
		for(int i = 0; i < N; i++){
			if(board[x][i] != '.')
				set.remove(board[x][i]-'0');
			if(board[i][y] != '.')
				set.remove(board[i][y]-'0');
		}
		//check the belonging box.
		int a = x / BASE, b = y / BASE;
		for(int i = 0; i < BASE; i++){
			for(int j = 0; j < BASE; j++){
				if(board[i+a][j+b] != '.')
					set.remove(board[i+a][j+b]-'0');
			}
		}
		return set;
	}
}
