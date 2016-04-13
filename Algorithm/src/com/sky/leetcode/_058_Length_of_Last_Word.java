package com.sky.leetcode;

public class _058_Length_of_Last_Word {
	
	public static void main(String args[]){
		_058_Length_of_Last_Word test = new _058_Length_of_Last_Word();
		String s = "11";
		System.out.println(test.lengthOfLastWord(s));
	}
	
	public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        int end = s.length() - 1;
        while(end >= 0 && s.charAt(end) == ' ') end--;
        for(int i = end; i >= 0; i--){
        	if(s.charAt(i) == ' ')
        		return end - i;
        }
        return end + 1;
    }
}
