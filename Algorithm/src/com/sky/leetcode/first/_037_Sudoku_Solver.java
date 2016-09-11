package com.sky.leetcode.first;

import java.util.HashSet;
import java.util.Set;

public class _037_Sudoku_Solver {
	
	private static final int BASE = 3;
	private static final int N = BASE * BASE;
	
	public static void main(String args[]){
		_037_Sudoku_Solver test = new _037_Sudoku_Solver();
		String s = "[..9748...,7........,.2.1.9...,..7...24.,.64.1.59.,.98...3..,...8.3.2.,........6,...2759..]";
		char[][] board = test.getBoard(s);
		System.out.println(test.solveSudoku(board));
	}
	
	
	//=====================================================================
	//采用回溯思想求解
    public boolean solveSudoku(char[][] board) {
        for(int i = 0; i < N; i++){
        	for(int j = 0; j < N; j++){
        		char c = board[i][j];
        		if(c == '.'){
        			Set<Character> candidates = getCandidates(i,j,board);
        			if(candidates.isEmpty()) 
        				return false;
        			for(char candidate : candidates){
        				board[i][j] = candidate; 
        				if(solveSudoku(board))
        					return true;
        				else 
        					board[i][j] = '.';
        			}
        			return false;
        		}
        	}
        }
        return true;
    }
    
    
    public Set<Character> getCandidates(int x,int y,char[][] board){
		Set<Character> set = new HashSet<Character>();
		for(int i = 1; i <= N; i++) set.add((char) (i+'0'));
		//check left to right and up to down.
		for(int i = 0; i < N; i++){
			if(board[x][i] != '.')
				set.remove(board[x][i]);
			if(board[i][y] != '.')
				set.remove(board[i][y]);
		}
		//check the belonging box.
		int a = x / BASE, b = y / BASE;
		for(int i = 0; i < BASE; i++){
			for(int j = 0; j < BASE; j++){
				if(board[ i + a * BASE][ j + b * BASE] != '.')//MISTAKE we forget to multiply base here !!
					set.remove(board[ i + a * BASE][ j + b * BASE]);
			}
		}
		return set;
	}
    
    public  char[][] getBoard(String s){
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

}
