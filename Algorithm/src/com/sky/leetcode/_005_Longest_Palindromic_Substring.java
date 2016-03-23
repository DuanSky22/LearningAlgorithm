package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2016年3月16日 下午4:36:18
 * @content 
 */

public class _005_Longest_Palindromic_Substring {
	
	public static void main(String args[]){
		_005_Longest_Palindromic_Substring test = new _005_Longest_Palindromic_Substring();
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		System.out.println(test.longestPalindrome_1(s));
		System.out.println(test.longestPalindrome_2(s));
	}
	
	
	
	//建立N*N的索引 可以过 124ms 7.25%
	public String longestPalindrome_2(String s){
        if(s == null || s.length() < 2) return s;
        boolean[][] map = createIndex(s);
        String s1 = core_21(s,map);
        String s2 = core_22(s,map);
        if(s1 == null) return s2;
        if(s2 == null) return s1;
        return s1.length() < s2.length() ? s2 : s1;
	}
	
	//建立索引
	public boolean[][] createIndex(String s){
		if(s == null) return null;
		int n = s.length();
		boolean[][] res = new boolean[n][n];
		for(int i = 0; i < n; i ++){
			for(int j = 0; j < n; j++){
				res[i][j] = (s.charAt(i) == s.charAt(j));
			}
		}
		return res;
	}
	
	
	//pairs
	public String core_21(String s, boolean[][] map){
		int n = s.length();
		String res = "";
		for(int i = 1; i < n; i++){
			if(map[i-1][i]){
				int curr = 2, k = 1;
				while( i + k < n && i - 1 - k >= 0 && map[i+k][i-1-k]){
					curr += 2 ;
					k ++;
				}
				res = (res == null || res.length()< curr) ?  s.substring(i-k,i+k) : res;
			}
		}
		return res;
	}
	
	//single
	public String core_22(String s,boolean[][] map){
		int n = s.length();
		String res = "";
		for(int i = 1; i < n -1 ; i++){
			if(map[i-1][i+1]){
				int curr = 3, k = 2;
				while( i - k >= 0 && i + k < n && map[i-k][i+k]){
					curr += 2;
					k ++;
				}
				res = (res == null || res.length()< curr)? s.substring(i-k+1,i+k) : res;
			}
		}
		return res;
	}
	
	
	//===========================================================================//
	//直接暴力破解time limit exceeded! 14ms
	public String longestPalindrome_1(String s) {
        if(s == null || s.length() < 2) return s;
        String s1 = core_1(s);
        String s2 = core_2(s);
        if(s1 == null) return s2;
        if(s2 == null) return s1;
        return s1.length() < s2.length() ? s2 : s1;
    }
	
	//pairs
	public String core_1(String s){
		int n = s.length();
		String res = "";
		for(int i = 1; i < n; i++){
			char a1 = s.charAt(i-1);
			char a2 = s.charAt(i);
			if(a1 == a2){
				int curr = 2, k = 1;
				while( i + k < n && i - 1 - k >= 0 && s.charAt(i+k)==s.charAt(i-1-k)){
					curr += 2 ;
					k ++;
				}
				res = (res == null || res.length()< curr) ?  s.substring(i-k,i+k) : res;
			}
		}
		return res;
	}
	
	//single
	public String core_2(String s){
		int n = s.length();
		String res = "";
		for(int i = 1; i < n -1 ; i++){
			char a1 = s.charAt(i-1);
			char a2 = s.charAt(i+1);
			if(a1 == a2){
				int curr = 3, k = 2;
				while( i - k >= 0 && i + k < n && s.charAt(i-k)==s.charAt(i+k)){
					curr += 2;
					k ++;
				}
				res = (res == null || res.length()< curr)? s.substring(i-k+1,i+k) : res;
			}
		}
		return res;
	}
}
