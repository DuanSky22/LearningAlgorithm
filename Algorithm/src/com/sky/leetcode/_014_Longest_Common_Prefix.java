package com.sky.leetcode;

public class _014_Longest_Common_Prefix {
	public String longestCommonPrefix(String[] strs) {
       if(strs == null || strs.length == 0) return "";
       int i = 0; boolean flag = true;
       while(flag){
    	   if(strs[0].length() == i) break;
    	   char  c = strs[0].charAt(i);
    	   for(int k = 0; k < strs.length; k++){
    		   if(strs[k].length() == i || strs[k].charAt(i) != c){//到达了某个字符串的末尾
    			   flag = false;
    			   break;
    		  	}
    	   } 
    	   if(flag) i++;
       }
       
       return strs[0].substring(0,i);
    }
}
