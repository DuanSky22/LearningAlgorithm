package com.sky.brainstroming;

import java.util.Stack;

/*
 *  @author: DuanSky
 *    @time: 2015��8��20�� ����3:43:51
 * @content:
	�����Ŀ�����ܹ��Զ�����û�������ַ����е����������Ƿ�ƥ�䡣
��������Ű�����<([{}])>
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
