package com.njz.leetcode;


import java.util.HashMap;
import java.util.Map;

public class _242_ValidAnagram {

	public static boolean isAnagram(String s, String t){
		if(s.length() != t.length())
			return false;
		
		Map<String, Integer> dic = new HashMap<String, Integer>();
		for(int i=0; i<s.length(); i++){
			String tmp = s.substring(i, i+1);
			if(dic.containsKey(tmp))
				dic.put(tmp, dic.get(tmp)+1);
			else
				dic.put(tmp, 1);
		}
		
		for(int i=0; i<t.length(); i++){
			String tmp = t.substring(i, i+1);
			if(dic.containsKey(tmp))
				dic.put(tmp, dic.get(tmp)-1);
			else
				dic.put(tmp, 1);
		}
		
		for(String key : dic.keySet()){
			if( dic.get(key)!=0 )
				return false;
		}
			
		return true;
	}
	
	public static void main(String[] args) {
		String a1 = "anagram";
		String a2 = "nagaram";
		String b1 = "rat";
		String b2 = "car";
		
		System.out.println(a1+" , "+a2+" : "+isAnagram(a1, a2));
		System.out.println(b1+" , "+b2+" : "+isAnagram(b1, b2));
	}

}
