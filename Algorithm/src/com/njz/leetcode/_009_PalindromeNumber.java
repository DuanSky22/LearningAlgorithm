package com.njz.leetcode;

public class _009_PalindromeNumber {
	
	public static boolean isPalindrome(int x) {
		if(x < 0)
			return false;
		
		int flag = 1;
		while(x/flag >= 10){
			flag *= 10;
		}
		
		int left = 0;
		int right = 0;
		while(x != 0){
			right = x % 10;
			left = x / flag;
			
			x = x % flag;
			x = x / 10;
			flag /= 100;
			
			if(right != left)
				return false;
		}
		return true;
		
    }
	
	public static void main(String[] args) {
		int x = 5;
		System.out.println(x + " : " + isPalindrome(x));
	}
}
