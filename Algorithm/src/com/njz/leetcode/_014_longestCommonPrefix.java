package com.njz.leetcode;

public class _014_longestCommonPrefix {

	public static String longestCommonPrefix(String[] strs) {
		if(strs==null || strs.length==0)
			return "";
		
        String prefix = strs[0];
        for(int i=1; i<strs.length; i++){
        	if(prefix.length()==0 || strs[i].length()==0)
        		return "";
        	
        	int len = prefix.length() < strs[i].length()? prefix.length() : strs[i].length();
        	int j = 0;
        	while(j<len){
        		if(prefix.charAt(j) != strs[i].charAt(j))
        			break;
        		j++;
        	}
        	prefix = prefix.substring(0, j);
        }//end for
        
        return prefix;
    }
	
	public static void main(String[] args){
		String[] a = {"abcdefg","abcdlijf","abc"};
		String rs1 = longestCommonPrefix(a);
		System.out.println("rs1 : "+rs1);
	}
	
}
