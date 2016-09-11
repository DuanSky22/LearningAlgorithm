/**
* @author DuanSky
* @date 2015��10��25�� ����1:28:03
* @content 
*/
package com.sky.leetcode.first;

public class _231_PowerofTwo {

	public boolean isPowerOfTwo(int n) {
        if(n<=0)
            return false;
        int counter=0;
        while(n!=0){
            counter+=n & 1;
            if(counter > 1)
                return false;
            n>>>=1;
        }
        return true;
    }
}
