package com.sky.bop;

import java.util.HashMap;
import java.util.Map;
/*
 * 
 * -1
-2147483648
 */

public class _206_精确表达浮点数 {
	
	public static void main(String args[]){
		_206_精确表达浮点数 test = new _206_精确表达浮点数();
//		int numerator = -1;
//		int denominator = -2147483648;
//		System.out.println(test.fractionToDecimal(numerator, denominator));
		System.out.println(test.decimalToFraction("3.(33)"));
	}
	
	public String decimalToFraction(String decimal){
		int pos = decimal.indexOf('.'); //找到.的位置
		int length = decimal.length();
		String res = "";
		long a = 0, b = 0;
		if(decimal.contains("(")){//无限循环小数
			int left = decimal.indexOf('(');
			int right = decimal.indexOf(')');
			int m = left - pos - 1;
			int n = right - left - 1;
			 b = (long) (Math.pow(10, m) * (Math.pow(10, n) - 1));
			 a = (long) (Integer.parseInt(decimal.substring(0,pos)+decimal.substring(pos+1,left)) * 
					(Math.pow(10, n) - 1) + Integer.parseInt(decimal.substring(left+1,right))); 
		}else{//有限小数
			 b = (long) Math.pow(10, length - pos - 1);
			 a = (long) (Double.parseDouble(decimal) * b);
			
		}
		long t = gcd2(a,b);
		return a/t + "/" + b/t;
	}
	
	public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";
        String res = "";
        //两个数相反，结果为负
        if((numerator < 0 ? true : false) ^ (denominator < 0 ? true : false)) res+="-";
        long a = Math.abs((long)numerator),b = Math.abs((long)denominator);
        //先加上整数部分
        res += a/b; a %= b;
        if(a == 0) return res; //如果刚好能够被整除，直接返回。
        res += '.'; //加上小数点
        Map<Long,Integer> map = new HashMap<>(); //余数 -> 位置的映射
        map.put(a, res.length()); //把余数放入
        while(a != 0){//余数为0表示能够给整除
        	a *= 10; //余数先要乘上10
        	res += a/b; //加上余数
        	a %= b; //剩下的余数
        	if(map.containsKey(a)){//如果在map中找到了该余数，说明开始重复
        		res = res.substring(0,map.get(a)) + "(" + res.substring(map.get(a),res.length());
        		res += ")";
        		return res;
        	}else
        		map.put(a, res.length());
        }
        return res;
    }

	public long gcd2(long a,long b){
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
