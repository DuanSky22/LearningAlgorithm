package com.sky.leetcode.first;

public class _009_PalindromeNumber_NotFinished {
	
	public static void main(String args[]){
		System.out.println(isPalindrome2(322123));
	}
	
	public static boolean isPalindrome2(int x){
		if(x < 0 || (x != 0 && x % 10 == 0)) return false;
		int sum = 0;
		while(x > sum) {
			sum = sum * 10 + x % 10;
			x /= 10;
		}
		return x == sum || x == sum / 10;
	}
	
	public static boolean isPalindrome1(int x){
		if(x < 0) return false;
		if(x < 10) return true;
		int count = 0, temp = x, j = 0;
		while(temp != 0){
			temp /= 10;
			count++;
		}
		while(j < count/2){
			int base = (int)Math.pow(10, count - 2 * j - 1);
			if(x % 10 != x / base) return false;
			x -= x / base * base;
			x /= 10;
			j++;
		}
		return true;
	}
	
	public static boolean isPalindrome0(int x){
		if(x<0)
			return false;
		int temp_x=x;
		int temp1_x=x;
		int carry=0;
		while(temp1_x!=0){
			carry++;
			temp1_x/=10;
		}
		return true;
	}
	//this function does not work on all integers for the reason of over flow!
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
//			int t=(int) (Math.pow(10, carry-i));
//			int k=t*left;
			//here when i is INTEGER.MAX_VALUE, reverse_x get wrong answer!
			//Which reverse_x value over flow!
			reverse_x+= left * (int)Math.pow(10, carry-i);
			temp_x/=10;
		}
		return reverse_x==x;
    }

}
