package com.sky.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DuanSky
 * @date 2016年4月1日 下午8:32:26
 * @content 
 */

public class _089_Gray_Code {

	
	public static void main(String args[]){
		_089_Gray_Code test = new _089_Gray_Code();
		System.out.println(test.grayCode(3));
	}
	

	public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        int curr = 0; res.add(curr); int k = 1;
        for(int i = 0; i < n; i++){
        	curr += k;
        	k<<=1;
        	res.add(curr);
        } k=1;
        for(int i = 0; i < n-1; i++){
        	curr-= k;
        	k<<=1;
        	res.add(curr);
        }
        
        return res;
    }
	
	
	
}