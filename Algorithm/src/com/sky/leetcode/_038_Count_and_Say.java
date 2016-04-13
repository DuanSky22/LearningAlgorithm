package com.sky.leetcode;

public class _038_Count_and_Say {

	
	public static void main(String args[]){
		_038_Count_and_Say test = new _038_Count_and_Say();
		int n = 5;
		System.out.println(test.countAndSay(n));
	}
	
	public String countAndSay(int n) {
        String res = "1";
        int k = 1;
        while(k++ < n){
        	//res = generate(res);
        	String temp ="";
        	int i = 0, j = 0; 
        	while( i < res.length() ){
        		j = i;
        		while(j < res.length() && res.charAt(j) == res.charAt(i))
        			j++;
        		temp += (j - i) + "" + (res.charAt(i) - '0');
        		i = j;
        	}
        	res = temp;
        }
        return res;
    }
}
