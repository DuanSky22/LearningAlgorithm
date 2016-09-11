package com.sky.leetcode.first;

import java.util.ArrayList;
import java.util.List;

public class _017_Letter_Combinations_of_a_Phone_Number {
	
	public static void main(String args[]){
		_017_Letter_Combinations_of_a_Phone_Number test = new _017_Letter_Combinations_of_a_Phone_Number();
		String digits = "2";
		System.out.println(test.letterCombinations(digits));
	}
	
	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<String>();
		if(digits == null || digits.length() == 0) return res;
		final char[][] map = {
				{'a','b','c'}, 		//2
				{'d','e','f'}, 		//3
				{'g','h','i'}, 		//4
				{'j','k','l'},		//5
				{'m','n','o'},		//6
				{'p','q','r','s'},	//7
				{'t','u','v'},		//8
				{'w','x','y','z'}	//9
		};
		int[] pos = new int[digits.length()];
		int total = 1, k = 0;
		for(int i = 0; i < digits.length(); i++)
			total *= map[digits.charAt(i)-'0' - 2].length;
		while(k++ < total){
			StringBuilder curr = new StringBuilder();
			for(int i = 0; i < digits.length(); i++){
				curr.append(map[digits.charAt(i)-'0'-2][pos[i]]);
			}
			res.add(curr.toString());
			//add one to pos
			int carry = 1;
			for(int i = 0; i < pos.length; i++){
				if(pos[i] + carry == map[digits.charAt(i) - '0' - 2].length){
					carry = 1;
					pos[i] = 0;
				}else{
					pos[i]++; break;
				}
			}
			
		}
		return res;
    }
}
