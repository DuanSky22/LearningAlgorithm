package com.njz.leetcode;

import java.util.Stack;

public class _242_ValidParentheses {
	
	//stack
	public static boolean isvalid(String s){
		if(s==null || s.length()<2)
			return false;
		
		Stack<String> stack = new Stack<String>();
		for(int i=0; i<s.length(); i++){
			String cur = s.substring(i, i+1);
			if(cur.equals("]") || cur.equals("}") || cur.equals(")")){
				if(stack.isEmpty())
					return false;
				String pre = stack.pop();
				if((cur.equals("]")&&!pre.equals("[")) || (cur.equals(")")&&!pre.equals("(")) || (cur.equals("}")&&!pre.equals("{")))
					return false;
			}else{
				stack.push(cur);
			}
		}//end-for
		if(stack.isEmpty())
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		String s = new String("((");
		System.out.println(s+" : "+isvalid(s));
	}

}
