/**
* @author DuanSky
* @date 2015��9��29�� ����11:52:57
* @content 
*/
package com.sky.leetcode.first;

public class _190_ReverseBits {
	 // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result=0;
        for(int i=0;i<32;i++){
            int bit=n & 1;
            result<<=1;
            result+=bit;
            n>>>=1;
        }
        return result;
    }
}
