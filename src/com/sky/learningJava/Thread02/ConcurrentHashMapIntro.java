package com.sky.learningJava.Thread02;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapIntro {

	public static void main(String args[]){
		ConcurrentHashMap<String,Integer> chm=new ConcurrentHashMap<String,Integer>();
		chm.put("a", 1);
		chm.get("a");
	}
}
