/**
* @author DuanSky
* @date 2015��10��13�� ����12:53:37
* @content 
*/
package com.sky.leetcode.first;

import java.util.ArrayList;
import java.util.List;

public class _022_GenerateParentheses_NotFinished {
	
	public static void main(String args[]){
		generateParenthesis(4);
	}
	public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public static void backtrack(List<String> list, String str, int open, int close, int max){

         if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }
}