package com.sky.leetcode;

public class _006_ZigZag_Conversion {
	
	public static void main(String args[]){
		_006_ZigZag_Conversion test = new _006_ZigZag_Conversion();
		String s = "ABCDEF";
		int numRows = 4;
		System.out.println(test.convert(s, numRows));
	}

	public String convert(String s, int numRows) {
		StringBuffer[] res = new StringBuffer[numRows];
		for(int j = 0; j < numRows; j++)
			res[j] = new StringBuffer();
		int i = 0;
		while( i < s.length()){
			int k = 0;
			while(i < s.length() && k < numRows) //up to down.
				res[k++].append(s.charAt(i++));
			while(i < s.length() && k > 2) //down to up.
				res[--k-1].append(s.charAt(i++));
		}
		String t = "";
		for(int j = 0; j < numRows; j++)
			t += res[j].toString();
		return t;
	}

	
}
