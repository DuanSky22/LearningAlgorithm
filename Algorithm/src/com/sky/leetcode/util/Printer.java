/**
* @author DuanSky
* @date 2015��9��9�� ����9:29:38
* @content 
*/
package com.sky.leetcode.util;

import java.util.List;

public class Printer {
	public static void printObject(Object o){
		System.out.println(o);
	}
	public static void printList(List list){
		for(Object o : list){
			System.out.print(o+" ");
		}
		System.out.println();
	}
}
