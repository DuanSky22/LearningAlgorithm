package com.njz.leetcode;

public class _006_ZigZagConversion {
	
	//“之”字形结�?  zigzag＝＝＝�?�之�?
	public static String ZigZagConversion(String s, int rows){
		if(s==null)
			return null;
		if(rows < 1)
			return null;
		if(rows == 1)
			return s;
		
		int len = s.length();
		if(rows > len)
			return s;
		
		String rs = new String();
		
		for(int r=0; r<rows; r++){
			
			int index = r;//当前行第�?个字�?---第一�?
			rs += s.charAt(index);
			
			for(int col=1; index<len; col++){//遍历�?有列
				if(r==0 || r==rows-1)
					index += 2*rows-2;
				else{
					if((col&1) == 1)//odd
						index += 2*rows-2*r-2;
					else//even
						index += 2*r ;
				}
				
				if(index<len)
					rs += s.charAt(index);
			}//end for2
		}//end for1
		
		return rs;
	}
	
	public static void main(String[] args){
		String rs1 = ZigZagConversion("abcd",4);
		System.out.println("rs1 : "+rs1);
	}
	
}
