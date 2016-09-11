/**
* @author DuanSky
* @date 2015��10��19�� ����6:45:02
* @content 
*/
package com.sky.leetcode.first;

public class _202_HappyNumber {
	public boolean isHappy(int n) {
        int slow=happy(n);
        int fast=happy(slow);
        while(true){
        	if(slow==fast)
        		break;
        	slow=happy(slow);
        	fast=happy(happy(fast));
        }
        return slow==1 ? true : false;
    }
	
	public int happy(int n){
		int result=0;
		while(n!=0){
			int single = n%10;
			result+=single*single;
			n/=10;
		}
		return result;
	}
	
}
