/**
* @author DuanSky
* @date 2015年10月25日 下午1:28:03
* @content 
*/
package com.sky.leetcode;

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
