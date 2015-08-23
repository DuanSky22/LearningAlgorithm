/*
 * Anagram是回文的意思。本题的第一个算法写错了。没有理清题意。
 * 题目意思是说，只需判断两个字符串的构成是否一样，不用考虑字符串中字符出现的顺序。
 * 我理解的是，考虑两个字符串中，看他们的子串是否都构成回文。
 * 对于原文题目，只需要统计每个字符出现的次数即可。时间和空间消耗都是o(n)
 */
package com.sky.leetcode.easy;

public class _003_ValidAnagram {
	
	public static void main(String args[]){
		String s="anagram";
		String t="nagamar";
		System.out.println(isAnagram(s,t));
	}
	 public static boolean isAnagram(String s, String t) {
	        if(s==null && t==null)
	            return true;
	        if((s!=null && t==null) || (s==null && t!=null))
	            return false;
	        if(s.length()!=t.length())
	            return false;
	        int n=s.length();
	        int[] sCounter=new int[26];
	        int[] tCounter=new int[26];
	        for(int i=0;i<n;i++){
	            sCounter[s.charAt(i)-'a']+=1;
	            tCounter[t.charAt(i)-'a']+=1;
	        }
	        for(int i=0;i<26;i++){
	            if(sCounter[i]!=tCounter[i])
	                return false;
	        }
	        return true;
	    }
	/*
	public static boolean isAnagram(String s,String t){
		boolean finalResult=true;
		if(s==null && t==null)
			return true;
		if((s==null && t!=null) || (s!=null && t==null))
			return false;
		if(s.length()!=t.length())
			return false;
		int n=s.length();
		if(n==1)
			return s.equals(t);
		int start=0;
		int end=start+1;
		while(start<n){
			boolean tempResult=false;
			for(end=start+1;end<n;end++){
				//test s[start,...,end]=t[end,...,start]
				boolean testResult=true;
				for(int offset=0;offset<=end-start;offset++){
					if(s.charAt(start+offset)!=t.charAt(end-offset)){
						testResult=false;
						break;
					}
				}
				tempResult=tempResult || testResult;
				if(testResult){
					start=end+1;
					break;
				}
			}
			finalResult=finalResult && tempResult;
			if(end==n)
				break;
		}
		return finalResult;
	}
	*/

}
