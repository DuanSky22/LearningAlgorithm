package com.sky.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author DuanSky
 * @date 2016年3月9日 下午2:54:30
 * @content 
 * "9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253"
 */

public class _091_Decode_Ways_2_rounds {
	
	public static void main(String args[]){
		_091_Decode_Ways_2_rounds test = new _091_Decode_Ways_2_rounds();
		String s = "100";
		System.out.println(test.solution_2(s));
		System.out.println(test.solution_1(s));
		System.out.println(test.solution_3(s));
	}
	
	//采用动态规划思想解题，总感觉判断条件太多！需要优化TODO 
	public int solution_3(String s){
		if(s==null ||s.length()==0 || s.charAt(0)=='0') return 0;
		int[] dp = new int[s.length()+1];
		dp[0] = 1; dp[1] = (s.charAt(0)>'0' && s.charAt(0)<='9' )? 1 : 0;
		for(int i=1;i<s.length();i++){
			char c = s.charAt(i); //当前字符
			int t =  Integer.parseInt(s.substring(i-1,i+1)) ; //当前字符和前一个字符组成的数字
			if(c == '0' &&( t > 26 || t==0)) return 0; //如果当前字符是0，而且当前字符又不能跟前面的字符组合，那么解码失败
			else if(c == '0' && t < 26) dp[i+1] = dp[i-1];
			else if( c != '0' && t > 26) dp[i+1] = dp[i];
			else if( c != '0' && t <= 26 && t > 10) dp[i+1] = dp[i-1] + dp[i];
			else if( c != '0' && t < 10) dp[i+1] = dp[i]; 
		}
		return dp[s.length()];
	}
	
	
	//带有记忆功能的深度优先遍历可以解决问题，但是空间复杂度增加了
	public int solution_2(String s){
		if(s==null ||s.length()==0) return 0;
		Map<String,Integer> memory = new HashMap<>();
		return dfsWithMemory(memory,s);
	}
	private int dfsWithMemory(Map<String,Integer> memory,String s){
		if(memory.containsKey(s)) return memory.get(s);
		if(s.length()==0) return 1;
		if(s.charAt(0)=='0') return 0;
		int a = dfsWithMemory(memory,s.substring(1));
		int b = 0, temp = s.length() >=2 ? Integer.parseInt(s.substring(0,2)) : 0 ;
		if(temp <= 26 && temp >= 10) b = dfsWithMemory(memory,s.substring(2));
		memory.put(s, a+b);
		return a+b;
	}
	
	//Time Limit Exceeded !!
	public int solution_1(String s){
		if(s==null || s.length()==0) return 0;
		return dfs(s,0);
	}
	private int dfs(String s,int start){
		if(start == s.length()) return 1;
		if(s.charAt(start)=='0') return 0;
		int a = dfs(s,start+1);
		int b = 0, temp = start+2<=s.length() ? Integer.parseInt(s.substring(start,start+2)) : 0;
		if(temp >= 10 && temp <= 26) b = dfs(s,start+2);
		return a + b;
	}

}
