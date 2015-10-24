/**
* @author DuanSky
* @date 2015年10月10日 下午7:47:47
* @content 
*/
package com.sky.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _008_StringtoInteger_1 {
	public static void main(String args[]){
		String str="      -11919730356x";
		System.out.println(myAtoi(str));
	}
	/*
	 * It's horrible!
	 */
	public static int myAtoi(String str) {
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
