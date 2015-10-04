package com.sky.leetcode;

public class FactorialTrailingZeroes {
	
	public static void main(String args[]){
		System.out.println(trailingZeroes(30));
	}
	/*
	 * The key point is how many factor number 5.
	 * specially take care of 5^n, for example 25 have two factors;
	 * 125 has three factors.
	 * First we count how many 5 included: N/5;
	 * Then we count how many 25 included: N/25;
	 * ...
	 * Finally we count how many 5^k included: N/5^k;
	 * we add them all.
	 */
	 public static int trailingZeroes(int n) {	 
		 return n==0 ? 0 : n/5+trailingZeroes(n/5);
	 }

}
