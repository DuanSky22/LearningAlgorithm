package com.sky.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DuanSky
 * @date 2016年3月20日 下午8:59:20
 * @content 
 */

public class _131_Palindrome_Partitioning {
	
	
	public static void main(String args[]){
		_131_Palindrome_Partitioning test = new _131_Palindrome_Partitioning();
		String s = "cdd";
		System.out.println(test.partition(s));
		System.out.println(test.divide(s));
	}
	
	
	//============================================================
	//贪心思想，分而治之
	public List<List<String>> divide(String s){
		List<List<String>> res = new ArrayList<>();
		if(s == null || s.length() == 1 || isPalindrome(s)){
			List<String> list = new ArrayList<String>();
			list.add(s); res.add(list);
		}
		for(int i = 0; i < s.length()-1; i++){
			String sub = s.substring(0,i+1); //左部分
			if(isPalindrome(sub)){
				List<List<String>> temp = divide(s.substring(i+1));
				for(List<String> list : temp){
					list.add(0, sub);
				}
				res.addAll(temp);
			}
		}
		return res;
	}
	
	
	//============================================================
	//DP 思想 DP[i]表示前i个字符能够组成的所有情况
	public List<List<String>> partition(String s) {
		List<List<String>> r = new ArrayList<>();
		r.add(new ArrayList<String>());
		if(s == null || s.length()==0) return r;
		if(s.length()==1){
			r.get(0).add(s); 
			return r;
		}
		int n = s.length();
		List<List<String>>[] res = new ArrayList[n];
		for(int i = 0; i < n; i ++) res[i] = new ArrayList<>();
		res[0].add(new ArrayList<String>());
		res[0].get(0).add(s.substring(0,1));
		for(int i = 1; i < n; i++){
			if(isPalindrome(s.substring(0,i+1))){//本身可以构成回文
				List<String> temp = new ArrayList<String>();
				temp.add(s.substring(0,i+1));
				res[i].add(temp);
			}
			for(int j = 0; j < i; j++){ //d[i] 可以分解为 d[j] + a[j+1]..[i]
				String sub = s.substring(j+1,i+1);
				if(isPalindrome(sub)){ //右边部分是可分割的
					res[i].addAll(copyList(res[j],sub));
				}
			}
		}
		return res[n-1];
    }
	
	public List<List<String>> copyList(List<List<String>> source,String a){
		List<List<String>> copy = new ArrayList<>();
		if(source == null || source.size() == 0) {
			copy.add(new ArrayList<String>());
			copy.get(0).add(a);
			return copy;
		}
		for(int i = 0; i < source.size(); i++){
			List<String> list = new ArrayList<String>();
			for(String s : source.get(i))
				list.add(s);
			list.add(a);
			copy.add(list);
		}
		return copy;
	}
	
	public boolean isPalindrome(String s){
		if(s == null || s.length() < 2) return true;
		int i = 0, j = s.length() -1;
		while(i <j ){
			if(s.charAt(i)!=s.charAt(j)) return false;
			i ++; j --;
		}
		return true;
	}


}
