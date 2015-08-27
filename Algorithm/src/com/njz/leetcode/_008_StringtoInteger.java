package com.njz.leetcode;

/*
 * 1. 输入""                           期待输出0

	2. 输入"     "                      期待输出0
	
	3. 输入"    -a4"                 期待输出0
	
	4. 输入"      -"                    期待输出0
	
	5. 输入"        90     "          期待输出90
	
	6. 输入"-3      "                  期待输出-3
	
	7. 输入"5abc3"                期待输出5
	
	8. 输入"004"                    期待输出4
	
	9. 输入"0.3"                      期待输出0
	
	10. 输入"2147483648"    期待输出 2147483647(题目给定了一个溢出的范围为[INT_MIN, INT_MAX],这个数溢出了，所以输出INT_MAX，取值为2147483647)
	
	11. 输入"-2147483649"   期待输出 2147483647(题目给定了一个溢出的范围为[INT_MIN, INT_MAX],这个数溢出了，所以输出INT_MIN，取值为-2147483648)
*/

public class _008_StringtoInteger {
	
    public static int myAtoi(String str) {
    	if(str == null || str.isEmpty())
    		return 0;
    	
        String s = str.trim();
        String rs = new String();
        boolean firstIsZero = true;
        boolean flag_ = true;
        
        for(int i=0; i<s.length(); i++){
        	
        	if( s.charAt(i) == '-' && flag_){
        		flag_ = false;
        		rs += '-';
        		continue;
        	}
        	
        	if( s.charAt(i) == '+' && flag_){
        		flag_ = false;
        		continue;
        	}

        	
        	char tmp = s.charAt(i);
        	
        	if(!isNum(tmp))
        		break;
        	
        	if(isNum(tmp) && tmp!='0'){
        		rs += tmp;
        		firstIsZero = false;
        	}
        	
        	if(tmp == '0')
        		if(firstIsZero)
        			continue;
        		else
        			rs += tmp;
        }
        
        if(rs.equals("") || rs.equals("-"))
        	return 0;
        
        long res =0;
        if(rs.contains("-")){
	        for(int i=1; i<rs.length(); i++)
	        	res += Integer.valueOf(String.valueOf(rs.charAt(i)))*(Math.pow(10.0, rs.length()-1-i));
	        res = -res;
        }
        else 
        	for(int i=0; i<rs.length(); i++)
        		res += Integer.valueOf(String.valueOf(rs.charAt(i)))*(Math.pow(10.0, rs.length()-1-i));
        
        if(res > Integer.MAX_VALUE)
        	res = Integer.MAX_VALUE;
        if(res < Integer.MIN_VALUE)
        	res = Integer.MIN_VALUE;
        
        return (int)res;
    }
    
    private static boolean isAlpha(char k){
    	if( ('A'-0 < k-0) && ('z'-0 > k-0))
    		return true;
    	return false;
    }
    
    private static boolean isNum(char k){
    	if(0<=k-'0' && k-'0'<=9)
    		return true;
    	return false;
    }
    
    public static void main(String[] args){
    	int rs1 = myAtoi(" +12 1232");
    	System.out.println("rs1 : "+rs1);
    }
}      