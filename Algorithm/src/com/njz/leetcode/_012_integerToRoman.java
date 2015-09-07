package com.njz.leetcode;

import java.util.HashMap;

public class _012_integerToRoman {
	
    public static String intToRoman(int number) {  
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };  
        String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };  
        
//        int[] values = {1000, 500, 100, 50, 10, 5, 1 };  
//        String[] numerals = {"M", "D", "C", "L", "X", "V", "I" };  
        
        StringBuilder result = new StringBuilder();  
        for (int i = 0; i < values.length; i++) {  
            while (number >= values[i]) {  
                number -= values[i];  
                result.append(numerals[i]);  
            }  
        }  
        return result.toString();  
    }   
    
    
    /*
     * 如果当前处理的字符对应的值和上一个字符一样，那么临时变量加上这个字符。比如III = 3
	如果当前比前�??个大，说明这�??段的值应该是当前这个值减去前面记录下的临时变量中的�?��?�比如IIV = 5 �?? 2
	如果当前比前�??个小，那么就可以先将临时变量的�?�加到结果中�??"然后�??始下�??段记�??"。比如VI = 5 + 1
     */
    public static int romanToInt(String s) {
    	if(s == null || s.isEmpty())
    		return 0;
    	
    	HashMap<Character, Integer> map = new HashMap<Character,Integer>();
    	int[] values = {1000, 500, 100, 50, 10, 5, 1 };  
    	char[] numerals = {'M', 'D', 'C', 'L', 'X', 'V', 'I' };
    	for(int i=0; i<values.length; i++)
    		map.put(numerals[i], values[i]);
    	
    	int len = s.length();
    	char pre = s.charAt(0);
    	int pre_value = map.get(pre);
    	int rs = 0;
    	int tmp = pre_value;
    	
    	for(int i=1; i<len; i++){
    		char cur = s.charAt(i);
    		int cur_value = map.get(cur);
    		
    		if(cur_value < pre_value){//直接加入临时变量
    			rs += tmp;
    			tmp = cur_value;
    		}else if(cur_value > pre_value){
    			tmp = cur_value - tmp;
    		}else{
    			tmp += cur_value;
    		}

    		pre_value = cur_value;
    	}
    	rs += tmp;
    	return rs;
    }
    public static void main(String[] args){
    	System.out.println(intToRoman(19));
    	System.out.println(romanToInt("XIX"));
    }
}
