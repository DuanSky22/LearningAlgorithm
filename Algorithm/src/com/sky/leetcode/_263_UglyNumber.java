/**
* @author DuanSky
* @date 2015年10月19日 下午6:23:19
* @content 
*/
package com.sky.leetcode;

public class _263_UglyNumber {
	public static void main(String args[]){
		int num=2;
		System.out.println(isUgly(num));
	}
	public static boolean isUgly(int num) {
        if(num<=0)//be careful 
            return false;
        while(num!=1){
            if(num%2==0)
                num/=2;
            else if(num%3==0)
                num/=3;
            else if(num%5==0)
                num/=5;
            else
                return false;
        }
        return true;
    }
}
