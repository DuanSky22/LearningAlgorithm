package com.njz.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _017_PhoneNumberCombination {
	
	public static List<String> rs = new ArrayList<String>();
	public static HashMap<Integer, String> map = new HashMap<Integer, String>();

	public static void creatMap(){
		map.put(0, "");
		map.put(1, "");
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
	}
	
	/*
	 * 回溯法，dfs
	 */
	public static List<String> letterCombinations(String digits) {
		
		if(digits == null || digits.isEmpty())
			return new ArrayList<String>();
		
		creatMap();
		int len = digits.length();
		
		DFS(0,len,digits,"");
		
		return rs;
    }
	
	public static void DFS(int dep, int MaxDep, String digits, String ans) {
		
		if(dep == MaxDep){
			rs.add(ans);
			return;
		}
		String tmp = map.get( Integer.valueOf(digits.substring(dep, dep+1)) );
		for(int i=0; i<tmp.length(); i++){
			String tmp1 = tmp.substring(i, i+1);
//			ans += tmp1;
			DFS(dep+1, MaxDep, digits, ans+tmp1);
		}
	}

	public static void main(String[] args){
		String num = new String("3");
		List<String> rs1 = letterCombinations(num);
		for(String s : rs1)
			System.out.print(s + " ");
	}
}
