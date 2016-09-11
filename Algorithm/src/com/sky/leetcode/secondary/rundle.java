package com.sky.leetcode.secondary;

/**
 * Created by SkyDream on 2016/9/10.
 */
char a ='张'；
public class rundle {
    public void run(){}

}

public class Test{
    public static void main(){
       synchronized (Test.class){
           try {
               Thread.sleep(100);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }
}
