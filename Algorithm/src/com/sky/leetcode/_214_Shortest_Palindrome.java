package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2016年3月17日 上午10:35:33
 * @content 
 * 
 */

public class _214_Shortest_Palindrome {
	
	public static void main(String args[]){
		_214_Shortest_Palindrome test = new _214_Shortest_Palindrome();
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		System.out.println(test.shortestPalindrome(s));
	}
	
	
	public String shortestPalindrome(String s) {
		if(s==null || s.length()<2 ||isPalindrome(s)) return s;
		int p1 = maxPalindrome_1(s); 
		int p2 = maxPalindrome_2(s);
		if(p1 > p2) return complete(s,p1,1);
		else return complete(s,p2,2);
    }

	//某个字符为中心位置
	public int maxPalindrome_1(String s){
		int i = 0, k = 1;
		for(i = ( s.length() - 1 ) / 2; i >= 0; i--){
			k = 1;
			while( i - k >= 0 && i + k < s.length() && s.charAt(i-k)==s.charAt(i+k)){
				k++;
			}
			if(i - k < 0) return i;
		}
		return i;
	}
	//某两个相邻的字符为中心位置
	public int maxPalindrome_2(String s){
		int i = 0, k = 1;
		for( i = s.length() / 2 - 1; i >= 0; i--){
			while( i + 1 - k >= 0 && i + k < s.length() && s.charAt(i+1-k)==s.charAt(i+k))
				k++;
			if(i + 1 - k < 0) return i;
		}
		return i;
	}
	//补全
	public String complete(String s, int pivot,int mode){
		return new StringBuilder(s.substring(pivot+1)).reverse().toString()+s.substring(pivot + mode - 1);
	}
	//判断一个字符是否可以构成回文
	private boolean isPalindrome(String s) {
		if(s == null || s.length() < 2) return true;
		int i = 0, j = s.length()-1;
		while(i<j){
			if(s.charAt(i)!=s.charAt(j)) return false;
			i++; j--;
		}
		return true;
	}
}
