package com.sky.learningJava.String;
/*
 * StringBuilder和StringBuffer类是为了弥补String类不能修改内容的缺陷而提出的。
 * StringBuilder类可以在原对象的基础上，动态的插入、删除和替换字符或字符串。
 */
public class StringBuilderIntro {
	
	public static void main(String a[]){
		String java="Java";
		StringBuilder builder=new StringBuilder(java);
		StringBuilder builder2=new StringBuilder();
		builder2=builder;
		builder.append(" and HTML");
		builder.reverse();
		
		print(builder);
		print(builder2);
	}
	
	public static void print(Object o){
		System.out.println(o);
	}

}
