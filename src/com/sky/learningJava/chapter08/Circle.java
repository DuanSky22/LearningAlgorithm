package com.sky.learningJava.chapter08;

public class Circle {

	//类中变量可以在类内任何地方声明和使用。但一个变量需要使用另外一个变量的情况除外
	//如果方法中的局部变量和类同名，则使用方法中定义的局部变量，类中的变量被隐藏。
	//this 指的是对象的引用变量
	public double getArea(){
		double radius=this.radius;
		return radius*radius*Math.PI;
	}
	private double radius;
	
	//this 的第二个用途是调用构造方法
	public Circle(){
		this(1);
	}
	public Circle(double radius){
		this.radius=radius;
	}
	
}
