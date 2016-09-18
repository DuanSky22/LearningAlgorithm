package com.sky.company.tencent;

import java.util.Scanner;

/**
 * Created by DuanSky on 2016/9/11.
 */
public class Test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();
            System.out.println(getResult0(n));
        }
    }

    public static int getResult(int n){
        int res;
        if(n <= 2) //如果n不超过2位，则肯定所有的组合都是黑系
            res = (int)Math.pow(3,n);
        else{
            int[] p = new int[n+1]; //p[k]表示到第k位时，k位和k-1位相同时的黑系组合数
            int[] q = new int[n+1]; //q[k]表示到第k位时，k位和k-1位不同时的黑系组合数
            //则 有递推公式p[k+1] = p[k] + q[k]; q[k+1] = 2 * p[k] + q[k]
            p[2] = 3; q[2] = 6;
            for(int k = 2; k < n; k++){
                p[k+1] = p[k] + q[k];
                q[k+1] = 2 * p[k] + q[k];
            }
            res = p[n]+q[n];
        }
        return res;
    }

    public static int getResult0(int n){
        int res;
        if(n <= 2) //如果n不超过2位，则肯定所有的组合都是黑系
            res = (int)Math.pow(3,n);
        else{
            int p = 2,q = 6;
            int nextP = 0, nextQ = 0;
            for(int i = 2; i < n; i++){
                nextP = p + q;
                nextQ = 2 * p + q;
                p = nextP;
                q = nextQ;
            }
            res = p + q;
        }
        return res;
    }
}
