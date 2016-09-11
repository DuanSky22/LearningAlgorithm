package com.sky.company.jindong;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by SkyDream on 2016/9/5.
 */
public class LuckyNumber {

    public static void main(String args[]){
        for(int i = 1; i < 100; i++)
            System.out.println(getLuckyNumber(i));
    }

    public static String getLuckyNumber(int k){
        List<String> res = new LinkedList<>();
        return dfs(res,1,k);
    }

   public static String dfs(List<String> res,int layer, int k){
       List<String> currLayer = new LinkedList<>();
       if(res == null || res.size() == 0){
           currLayer.add("4");
           currLayer.add("7");
       }else{
           for(String single : res){
               currLayer.add(single + "4");
               currLayer.add(single + "7");
           }
       }
       if(Math.pow(2,layer) >= k)
           return currLayer.get(k-1);
       else
           return dfs(currLayer,layer+1,k-(int)Math.pow(2,layer));
   }
}
