package com.sky.bop;

public class _207_最大公约数问题_GCD {

	public static void main(String args[]){
		_207_最大公约数问题_GCD test = new _207_最大公约数问题_GCD();
		int a = 1234;
		int b = 12346;
		System.out.println(test.gcd0(a, b) +" "+ test.gcd1(a, b) + " "+test.gcd2(a, b));
	}
	
	//采用欧几里得算法 gcd(a,b) = gcd(b,a%b)
	public int gcd0(int a,int b){
		if(b == 0) return a;
		return gcd0(b,a%b);
	}
	//改进算子，将除法运算改为减法运算
	public int gcd1(int a,int b){
		if(b == 0) return a;
		if(a < b) return gcd1(b,a);
		return gcd1(a-b,b);
	}
	//利用两个公式进行加速
	public int gcd2(int a,int b){
		if(b == 0) return a;
		if(a < b) return gcd2(b,a);
		if( (a & 1) == 1){
			if( (b & 1) == 1) return gcd2(a-b,b);
			else return gcd2(a,b>>1);
		}else{
			if((b & 1) == 1) return gcd2(a>>1,b);
			else return 2*gcd2(a>>1,b>>1);
		}
	}
	
}
