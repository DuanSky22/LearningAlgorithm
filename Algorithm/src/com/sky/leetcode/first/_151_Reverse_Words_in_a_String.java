package com.sky.leetcode.first;

public class _151_Reverse_Words_in_a_String {
	
	public static void main(String args[]){
		_151_Reverse_Words_in_a_String test = new _151_Reverse_Words_in_a_String();
		String s = "hello world!";
		System.out.println(test.reverseWords(s));
	}
	
	//String[] parts = s.trim().split("\\s+"); 正则表达式！
	public String reverseWords(String s) {
        String res = "";
        while(s != null && s.length() !=0){
        	int pos = s.indexOf(' ');
        	if(pos == -1) {
        		res = s + " " + res; //没有空格
        		break;
        	}
        	String temp = s.substring(0,pos);
        	if(temp.length() != 0 && !temp.equals(" ")) 
        		res = temp + " " + res;
        	s = s.substring(pos + 1);
        	
        }
        return res.length() == 0 ? res : res.substring(0,res.length()-1);
    }
}
