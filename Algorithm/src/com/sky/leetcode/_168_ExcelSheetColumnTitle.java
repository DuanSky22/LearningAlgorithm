package com.sky.leetcode;

public class _168_ExcelSheetColumnTitle {
	
	public static void main(String args[]){
		System.out.print(convertToTitle(28));
	}
	
	public static String convertToTitle(int n) {
        String result="";
        char base='A';
        while(n!=0){
        	result=(char)(base+(n-1)%26)+result;
        	n=(n-1)/26;
        }
        return result;
    }

}
