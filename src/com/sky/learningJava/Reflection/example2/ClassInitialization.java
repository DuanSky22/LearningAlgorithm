package com.sky.learningJava.Reflection.example2;

import java.util.Random;

/*
 *  @author: DuanSky
 *    @time: 2015年8月19日 下午3:04:01
 * @content:

 */
class Initable{
	static final int a=47;
	static final int b=ClassInitialization.rand.nextInt(200);
	static {
		System.out.println("Initializing Initalbe");
	}
}
class Initable2{
	static int a=147;
	static {
		System.out.println("Initializing Initalbe2");
	}
}
class Initable3{
	static int a=1147;
	static {
		System.out.println("Initializing Initalbe3");
	}
}
public class ClassInitialization {
	public static Random rand=new Random();
	public static void main(String args[]) throws ClassNotFoundException{
		//根据打印结果可以看出，使用.class方法创建class对象的引用，
		//只是完成了加载和链接步骤，并没有执行初始化；
		//而是在该class的第一次被调用时（Initable.a）完成了初始化。
		Class initable=Initable.class;
		System.out.println("After creating initable ref");
		System.out.println(Initable.a);
		System.out.println(Initable.b);
		
		System.out.println(Initable2.a);
		//而使用Class.forName()方法，会立即进行初始化
		Class initable3=Class.forName("com.sky.learningJava.reflection.example.Initable3");
		System.out.println("After creating Initable3 ref");
		System.out.println(Initable3.a);
		
		
		
	}
}
