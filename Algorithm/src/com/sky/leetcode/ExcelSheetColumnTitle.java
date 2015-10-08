/**
* @author DuanSky
* @date 2015年9月30日 下午8:27:54
* @content 
*/
package com.sky.leetcode;

public class ExcelSheetColumnTitle {
	public static void main(String args[]){
//		char base='A';
//		for(int i=0;i<26;i++){
//			System.out.println((char)(base+i));
//		}
		System.out.println(convertToTitle(53));
	}
	public static String convertToTitle(int n) {
        String result="";
        if(n>0){
        	char base = 0;
        	int left = 0;
        	while(n!=0){
        		base='A';
                left=n%26;
                result=String.valueOf((char)(base+left-1))+result;
                n=n/26;
            }
        }
        return result;
    }
}
