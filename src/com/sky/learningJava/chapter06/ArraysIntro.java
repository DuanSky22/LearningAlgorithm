package com.sky.learningJava.chapter06;

public class ArraysIntro {

	public static void main(String args[]){
		//可以将int类型的值赋给double数组,以下是三种类型的声明和初始化
		double[] a1=new double[4];
		double[] a2={1,2};
		double[] a3=new double[]{1,2};
		
		System.out.println(a1.length);
		//思考{} 和new[]{} 有什么区别呢？
		double[] a4;
		a4=new double[]{1,2,3};
		//a4={1,2,3}; 会报错！
		
		//数组的长度到底可不可变？
		a1=new double[]{};
		a1=new double[2];
		a1=new double[3];
		
		System.out.println(a1.length);
	}
}
