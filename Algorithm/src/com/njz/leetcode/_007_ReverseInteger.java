package com.njz.leetcode;


public class _007_ReverseInteger {
	
	public static int reverse1(int x){
		long rs = 0;
		
		while(x != 0){
			rs = rs*10 + x%10;
			if (rs > Integer.MAX_VALUE || rs < Integer.MIN_VALUE)
				return 0;
			x /= 10;
		}
		return (int)rs;
	}
	
	public static int reverse2(int x){
		String tmp = String.valueOf(x);
		int len = tmp.length();
		long rs = 0;
		if(x > 0)
			for(int i=len-1; i>=0; i--){
				rs += Integer.parseInt(String.valueOf(tmp.charAt(i))) * Math.pow(10.0, i); 
			}
		else{
				for(int i=len-1; i>0; i--){
					rs += Integer.valueOf(String.valueOf(tmp.charAt(i))) * Math.pow(10.0, i-1); 
				}
				rs = -rs;
		}
		
		if (rs > Integer.MAX_VALUE || rs < Integer.MIN_VALUE)
			return 0;
		return (int)rs;
	}
	
	
	public static void main(String[] args){
		int rs1 = reverse1(1534236469);
		System.out.println("rs1 : "+rs1);
		int rs2 = reverse2(1534236469);
		System.out.println("rs2 : "+rs2);

	}
	
}
