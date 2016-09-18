package com.sky.company.netease;

import java.util.Scanner;

/**
 * Created by DuanSky on 2016/9/18.
 */
public class _01chuan {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int N = Integer.valueOf(in.nextLine());
        for(int i = 0; i < N; i++){
            String line[] = in.nextLine().split(" ");
            int k = Integer.valueOf(line[0]);
            String s = line[1];
            System.out.println(getResult(k,s));
        }
    }

    public static int getResult(int k, String s){
        if(s == null || s.length() == 0) return 0;
        int length = s.length();
        if(k == length) return calculate(s,'1');
        int max = 0; int curr = 0;
        for(int i = 0; i < length - k; i++){
            if(s.charAt(i) == '0') {
                curr++;//如果前面是0,可以先直接跳过，直到找到第一次出现1的地方。
                max = Math.max(max,curr);
            }
            else{//在出现1的地方对其进行反转
                char[] newS = s.substring(i).toCharArray();
                if(newS != null){
                    for(int j = 0; j < newS.length && j < k; j++){
                        if(newS[j] == '0') newS[j] = '1';
                        else newS[j] = '0';
                    }
                }
                int reverse = calculate(new String(newS),'0');
                max = Math.max(max,reverse + curr);
                //恢复到初始情况
                curr = 0;
            }
        }
        return max;
    }

    public static int calculate(String s,char c){
        int max = 0; int curr = 0;
        if(s == null || s.length() == 0) return 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == c){
                curr++;
            }else{
                max = Math.max(max,curr);
                curr = 0;
            }
        }
        return max;
    }
}
