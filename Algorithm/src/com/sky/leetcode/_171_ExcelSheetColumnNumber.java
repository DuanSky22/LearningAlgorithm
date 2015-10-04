package com.sky.leetcode;

public class _171_ExcelSheetColumnNumber {
	
	public static void main(String args[]){
		String a="AB";
		System.out.println(titleToNumber(a));
	}
	
	
	public static int titleToNumber(String s) {
        char base='A';
        int result=0;
        int length=s.length();
        for(int i=0;i<length;i++){
        	int number=s.charAt(i)-base+1;
        	result+=Math.pow(26, length-1-i)*number;
        }
        return result;
    }
}
