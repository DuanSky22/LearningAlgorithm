package com.sky.leetcode;

public class _279_Perfect_Squares {
	
	public static void main(String args[]){
		int n = 13;
		_279_Perfect_Squares test = new _279_Perfect_Squares();
		System.out.println(test.numSquares(n));
	}
	public int numSquares(int n) {
        int res[] = new int[n+1];
        res[0] = 0 ; res[1] = 1;
        for(int i = 2; i <= n; i++){
        	res[i] = Integer.MAX_VALUE;
        	for(int t = 1; t * t <= i; t++){
        		res[i] = Math.min(res[i], res[i-t*t]+1);
        	}
        }
        return res[n];
    }
}
