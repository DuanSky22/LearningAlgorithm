package com.sky.brainstroming;

import java.util.Stack;

/*
 *  @author: DuanSky
 *    @time: 2015年8月20日 下午3:43:51
 * @content:
	本题的目的是能够自动检测用户输入的字符串中的左右括号是否匹配。
这里的括号包括：<([{}])>
 */
public class _001_BracketMatching {
	public static void main(String args[]){
		String s="<a>c{b}()[d[<{}ad><>]]";
		System.out.println(isMatch(s));
	}
	public static boolean isMatch(String str){
		if(str==null || str.length()==0)
			return true;
		boolean result=false;
		Stack<Character> bracketStack=new Stack<Character>();
		int n=str.length();
		for(int i=0;i<n;i++){
			char tempChar=str.charAt(i);
			char topChar;
			switch(tempChar){
				case '<':
				case '[':
				case '(':
				case '{':
					bracketStack.push(tempChar);
					continue;
				case '>':
					if(bracketStack.isEmpty() ||
							(topChar=bracketStack.pop())!='<')
						return false;
					else
						continue;
				case ']':
					if(bracketStack.isEmpty() ||
							(topChar=bracketStack.pop())!='[')
						return false;
					else
						continue;
				case '}':
					if(bracketStack.isEmpty() ||
							(topChar=bracketStack.pop())!='{')
						return false;
					else
						continue;
				case ')':
					if(bracketStack.isEmpty() ||
							(topChar=bracketStack.pop())!='(')
						return false;
					else
						continue;
				default:
					continue;
			}
		}
		
		return bracketStack.isEmpty();
	}
}
