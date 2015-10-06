package com.sky.leetcode;

public class PalindromeNumber {
	
	public static void main(String args[]){
		System.out.println(isPalindrome(0));
	}
	
	public static boolean isPalindrome(int x) {
		if(x<0)
			return false;
		int reverse_x=x;
		int temp_x=x;
		int carry=0;
		while(reverse_x!=0){
			carry++;
			reverse_x/=10;
		}
		for(int i=1;i<=carry;i++){
			int left=temp_x % 10;
			reverse_x+=left * Math.pow(10, carry-i);
			temp_x/=10;
		}
		return reverse_x==x;
    }

}
