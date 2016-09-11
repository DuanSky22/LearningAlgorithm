package com.sky.leetcode.first;

import java.util.Stack;

public class _227_Basic_Calculator_II {
	
	public static void main(String args[]){
		_227_Basic_Calculator_II test = new _227_Basic_Calculator_II();
		String s = "1-2*5/3";
		System.out.println(test.calculate0(s));
	}
	
	public int calculate1(String s) {
	    int len;
	    if(s==null || (len = s.length())==0) return 0;
	    Stack<Integer> stack = new Stack<Integer>();
	    int num = 0;
	    char sign = '+';
	    for(int i=0;i<len;i++){
	        if(Character.isDigit(s.charAt(i))){
	            num = num*10+s.charAt(i)-'0';
	        }
	        if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
	            if(sign=='-'){
	                stack.push(-num);
	            }
	            if(sign=='+'){
	                stack.push(num);
	            }
	            if(sign=='*'){
	                stack.push(stack.pop()*num);
	            }
	            if(sign=='/'){
	                stack.push(stack.pop()/num);
	            }
	            sign = s.charAt(i); //缓存一下上一次的运算符号
	            num = 0;
	        }
	    }

	    int re = 0;
	    for(int i:stack){
	        re += i;
	    }
	    return re;
	}
	
	//采用栈的方式来满足运算的优先级
	public int calculate0(String s){
		int res = 0, thisNum = 0; 
		char thisOper = '+';
		Stack<Integer> stack = new Stack<>(); 
		s = thisOper + s;
		for(int i = 0; i < s.length();){
			if(s.charAt(i) == ' ') {
				i++;continue;
			}
			thisOper = s.charAt(i++); //先获取运算符
			while(s.charAt(i)  == ' ') i++; //跳过空行
			thisNum = 0;
			while(i < s.length() && Character.isDigit(s.charAt(i))){
				thisNum = thisNum * 10 + s.charAt(i)-'0';//再获取操作数
				i++;
			}
			if(thisOper == '+') stack.push(thisNum);
			else if(thisOper == '-') stack.push(-thisNum);
			else if(thisOper == '*') stack.push(stack.pop() * thisNum);
			else stack.push(stack.pop() / thisNum);
		}
		for(int curr : stack)
			res += curr;
		return res;
	}
	
	
	//采用回退方式来满足运算的优先级
	public int calculate(String s) {
		int res = 0, thisNum = 0, lastNum = 0;
		char thisOperator, lastOperator = '+';
		s = '+' + s;
        for(int i = 0; i < s.length(); ){
        	if(s.charAt(i) == ' ') {
        		i++;
        		continue;
        	}
        	thisOperator = s.charAt(i++); // 首先截取运算符
        	while(s.charAt(i)  == ' ') i++;
        	int end = i;
        	while(end < s.length() && Character.isDigit(s.charAt(end))) end++;
        	thisNum = Integer.parseInt(s.substring(i,end));
        	if((thisOperator == '*' || thisOperator == '/') &&
        			(lastOperator == '+' || lastOperator == '-')){ //需要会退一步
        		res = lastOperator == '+' ? res - lastNum : res + lastNum;
        		int curr = operator(thisOperator,lastNum,thisNum);
        		res = operator(lastOperator,res,curr);
        		lastNum = curr;
        	}else{
        		res = operator(thisOperator,res,thisNum);
        		lastNum = thisNum;
           	 	lastOperator = thisOperator;
        	}

        	i = end;
        }
        return res;
    }
	
	public int operator(char operator, int num1, int num2){
		switch(operator){
		case '+': return num1 + num2;
		case '-': return num1 - num2;
		case '*': return num1 * num2;
		default: return num1 / num2;
		}
	}
	
}
