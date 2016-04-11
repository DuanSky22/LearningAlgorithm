/**
* @author DuanSky
* @date 2015��10��10�� ����7:47:47
* @content 
*/
package com.sky.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _008_StringtoInteger_1 {
	public static void main(String args[]){
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println((int)'+');
		System.out.println((int)'-');
		String str="-1";
		System.out.println(myAtoi(str));
	}
	
	/*
	 * "010"=>"10"
	 * "+004500" => "4500"
	 */
	public static int myAtoi(String str){
		int res = 0, sign = 1, i = 0;
		//the first step : remove all breaks
		while(i<str.length() && str.charAt(i)==' ') 
			i++;
		if(i == str.length()) return 0;
		//the second step: get the sign of the number.
		if(str.charAt(i)=='-' || str.charAt(i)=='+'){
			sign = 44 - str.charAt(i); 
			i++;
		}
		//the third step: translate it.
		for(;i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9';i++){
			if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && str.charAt(i)>='7'))
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			res = res * 10 + str.charAt(i)-'0';
		}
		return res * sign;
	}
	
	/*
	 * It's horrible!
	 */
	public static int myAtoi_wrong_solution(String str) {
		int result=0;
        if(str.length()==0)
        	return 0;
        Map<Character,Integer> numbers=new HashMap<Character,Integer>();
        char base='0';
        for(int i=0;i<10;i++)
        	numbers.put((char) (base+i), i);
        while(str.charAt(0)==' ' || str.charAt(0)=='\n' || str.charAt(0)=='\t')
        	str=str.substring(1);
        //cut off the symbol of '+' or '-'.
        int flag=1;
        if(str.charAt(0)=='-'){
        	flag=-1;
        	str=str.substring(1);
        }
        else if(str.charAt(0)=='+'){
        	str=str.substring(1);
        }
        int carry=1;
        for(int i=str.length()-1;i>=0;i--){
        	char c=str.charAt(i);
        	if(numbers.containsKey(c)){
        		result+=carry*numbers.get(c);
        		carry*=10;
        	}
        	else{
        		result=0;
        		carry=1;
        	}
        }
        result=result*flag;
        if(flag==1 && result<0)
            result=Integer.MAX_VALUE;
        else if(flag==-1 && result>0)
            result=Integer.MIN_VALUE;
        return result;
    }
}
