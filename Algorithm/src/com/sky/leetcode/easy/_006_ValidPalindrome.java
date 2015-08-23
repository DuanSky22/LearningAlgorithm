package com.sky.leetcode.easy;
/*
 *  @author: DuanSky
 *    @time: 2015年8月22日 下午10:06:09
 * @content:
	这一题主要考察Java中char字符的过滤。
 */
public class _006_ValidPalindrome {
	public static void main(String args[]){
		for(int i=0;i<0xffff;i++){
			System.out.println((char)i);
		}
		String s="\"7Ci`rd,9X;;r9,dX`iC7\"";
		System.out.println(isPalindrome(s));
	}
	
	public static boolean isPalindrome(String s){
		if(s==null || s.length()==0)
			return true;
		int n=s.length();
		int start=0;
		int end=n-1;
		while(start<=end){
			char temp_start=s.charAt(start);
			char temp_end=s.charAt(end);
			if(!Character.isLetterOrDigit(temp_start)){
				start++;
				continue;
			}
			if(!Character.isLetterOrDigit(temp_end)){
				end--;
				continue;
			}
			if(Character.isLetter(temp_start) && Character.isLetter(temp_end)){
				if(Character.toLowerCase(temp_start)==Character.toLowerCase(temp_end)){
					start++;
					end--;
				}
				else
					return false;
			}	
			else
				if(temp_start!=temp_end)
					return false;
				else{
					start++;
					end--;
				}
		}
		return true;
	}
}
