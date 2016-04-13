package com.sky.leetcode;

public class _067_Add_Binary {
	
	public static void main(String args[]){
		_067_Add_Binary test = new _067_Add_Binary();
		String a = "1";
		String b = "10";
		System.out.print(test.addBinary(a, b));
	}
	
	 public String addBinary(String a, String b) {
		 String res = ""; 
		 int carry = 0, left = 0, m = 0, n = 0;
		 for(int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0;){
			 if(i == -1) m = 0;
			 else m = a.charAt(i--) - '0';
			 if(j == -1) n = 0;
			 else n = b.charAt(j--) - '0';
			 left = (carry + m + n) % 2;
			 carry = (carry + m + n) / 2;
			 res = left + res;
		 }
		 return carry == 1 ? 1 + res : res;
	 }
}
