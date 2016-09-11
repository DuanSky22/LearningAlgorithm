package com.sky.leetcode.first;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DuanSky
 * @date 2016年1月7日 下午10:52:43
 * @content 
 */

public class _241_Different_Ways_to_Add_Parentheses {
	
	final char[] operators={'+','-','*'};
	
	public List<Integer> diffWaysToCompute(String input) {
        return calculate(input);
    }
	
	public List<Integer> calculate(String input){
		List<Integer> list = new ArrayList<>();
		if(input.indexOf(operators[0])==-1 && input.indexOf(operators[1])==-1 && input.indexOf(operators[2])==-1){//如果只剩下一个元素
			list.add(Integer.valueOf(input));
		}
		else{//如果剩下超过两个元素，即三个及以上
			for(int i=0;i<input.length();i++){
				char op = input.charAt(i);
				if(op == operators[0]){
					List<Integer> left = calculate(input.substring(0,i));
					List<Integer> right = calculate(input.substring(i+1,input.length()));
					for(int l : left)
						for(int r : right)
							list.add(l+r);
				}
				else if(op == operators[1]){
					List<Integer> left = calculate(input.substring(0,i));
					List<Integer> right = calculate(input.substring(i+1,input.length()));
					for(int l : left)
						for(int r : right)
							list.add(l-r);
				}
				else if(op == operators[2]){
					List<Integer> left = calculate(input.substring(0,i));
					List<Integer> right = calculate(input.substring(i+1,input.length()));
					for(int l : left)
						for(int r : right)
							list.add(l*r);
				}
			}
		}
		return list;
	}
}
