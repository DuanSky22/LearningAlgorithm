package com.sky.basic;

/**
 * Created by SkyDream on 2016/7/20.
 */
public class _BitOperation {

    public static void main(String args[]){
        _BitOperation test = new _BitOperation();
        int n = 8;
        System.out.println(test.powerOf2(n));
        System.out.println(test.sizeOf2(n));
    }

    public boolean powerOf2(int n){
        if(n < 1) return false;
        return (n & (n-1)) == 0;
    }

    public int sizeOf2(int n){
        int count = 0;
        while(n != 0){
            count++;
            n &= (n-1);
        }
        return count;
    }
}
