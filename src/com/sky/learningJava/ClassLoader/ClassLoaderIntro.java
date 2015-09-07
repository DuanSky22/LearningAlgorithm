package com.sky.learningJava.ClassLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassLoaderIntro {
	//
	//类初始化情况之三：当调用一个类的main方法时，虚拟机会先初始化这个主类
	static{
		System.out.println("ClassLoaderIntro init");
	}
	public static void main(String args[]){
		System.out.println(ClassLoaderIntro.class.getClassLoader());
		//因为value是类A定义的静态变量，所以对该静态变量的引用
		//只会触发A类初始化，不会触发C类初始化。
		int aValue = C.value;
		ClassLoader c = C.class.getClassLoader();
		try {
			//装载类不一定会初始化类，初始化类有且仅有五种情况。
			c.loadClass("com.sky.learningJava.ClassLoader.A");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		ClassLoader system=c.getSystemClassLoader();
		ClassLoader a = A.class.getClassLoader();
		//Object类位于rt.jar包中，是由启动类加载器加载。所以下面
		//方法返回空值
		//采用class.forName也会初始化类
		ClassLoader object=Object.class.getClassLoader();
//		try {
//			Class.forName("com.sky.learningJava.ClassLoader.C");
//		} catch (ClassNotFoundException e1) {
//			e1.printStackTrace();
//		}
		//类需要初始化的五种情况之一：当使用反射调用时，需要先对类进行初始化
		//之二：当初始化一个类的时候，如果发现其父类还没有进行初始化，先要对
		//父类进行初始化
		Class classC=C.class;
//		Method[] methods=classC.getMethods();
//		for(Method method : methods){
//			System.out.println(method.toGenericString());
//			if(method.getName().equals("toString"))
//				try {
//					method.invoke(classC.newInstance());
//				} catch (IllegalAccessException | IllegalArgumentException
//						| InvocationTargetException | InstantiationException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//		}
		
		System.out.println(c+"\n"+a+"\n"+system);
	}
}


class B{
	static {
		System.out.println("B init");
	}
	private static class D{
		static{
			System.out.println("D init");
		}
	}
}
class C extends A{
	static{
		System.out.println("C init");
	}
}
