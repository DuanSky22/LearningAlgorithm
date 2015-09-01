package com.sky.learningJava.String;

public class StringIntro {

	public static void main(String args[]){
		String s1=new String("welcome");
		String s2="welcome";
		String s3="welcome";
		String s4="java";
		String s5=s2+s4;
		String s6="welcomejava";
		print(s5==s6);
		print(s5.equals(s6));
		print(s1==s2);
		print(s2==s3); //java对于内容相同的直接量，只用一个对象来存储。
		print(s1==s4);
		print(s1.equals(s2));
		print(s1.equals(s3));
		s1.length();
	}
	public static void print(Object o){
		System.out.println(o);
	}
}
