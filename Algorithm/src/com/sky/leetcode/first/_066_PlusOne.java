package com.sky.leetcode.first;

public class _066_PlusOne {
	
	public static void main(String args[]){
		int digits[]=new int[]{9,9};
		plusOne(digits);
	}
	
	 public static int[] plusOne(int[] digits) {
	        int carry=1;
	        int left=0;
	        for(int i=digits.length-1;i>=0;i--){
	            left=(digits[i]+carry)%10;
	            carry=(digits[i]+carry)/10;
	            digits[i]=left;
	            if(carry<1)
	                break;
	        }
	        if(carry<1)
	            return digits;
	        else{
	            int[] result=new int[digits.length+1];
	            for(int i=0;i<digits.length;i++){
	                result[i+1]=digits[i];
	            }
	            result[0]=1;
	            return result;
	        }
	    }
}
