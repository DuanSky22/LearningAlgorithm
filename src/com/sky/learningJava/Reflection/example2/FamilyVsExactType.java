package com.sky.learningJava.Reflection.example2;

import java.util.HashMap;
/*
 *  @author: DuanSky
 *    @time: 2015年8月19日 下午5:19:29
 * @content:

 */

public class FamilyVsExactType {
	public static void main(String args[]){
		String a="abbb";
		int i=0;
		while(i<1000000000L){
			i++;
		}
		String b="abbb";
		System.out.println(a==b);
	}

}
