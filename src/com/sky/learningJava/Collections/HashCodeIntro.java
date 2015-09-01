package com.sky.learningJava.Collections;

import java.util.HashSet;
import java.util.Set;

/*
 * 参考：http://www.cnblogs.com/dolphin0520/p/3681042.html
 * 
 * 一、什么是HashCode
 * hashCode是对象的一个映射。不同的类型映射的方法不太一样。
 * 基础类型中int的hashCode映射值为整型值；
 * char的hashCode映射值为char的unicode字符编码；
 * double的hashCode的映射值为double值的某种计算方式。
 * 基础类型的hashcode映射的结果只与基础类型实际存储的值有关，而与内存地址无关。
 * 引用类型的hashcode的映射默认情况下是对内存地址映射。
 * 
 * 二、为什么要用HashCode
 * hashCode可以说是为了快速比较两个对象是否相等的方法。
 * hashcode的效率比equals方法的执行效率要高多了。如果在一个超大的集合中，检查新插入的对象是否已经存在于这个集合中，
 * 那么调用Equals方法将会很慢。根据原则：如果两个对象的hashcode不相等，那么这两个对象一定不相同。可以先比较这个对象
 * 和集合中的对象的hashcode是否相同，如果不相同，那么这两个对象肯定不相等；如果相同，再调用equals方法来比较是否真的
 * 相同（因为hashcode相同的两个对象，不一定真的相同）。这样效率要提高很多。
 * 
 * 三、HashCode和equals
 * 在进行重写equals方法的时候，一定要注意重写hashcode方法，以保持逻辑意义上的一致。
 * 一般有如下设计原则：
 * 1. equals相等的两个对象，hashcode值一定相等；
 * 2. hashCode相等的两个对象，equals不一定相等；
 * 3. 在程序执行期间，只要equals方法的比较操作用到的信息没有被修改，那么对这同一个对象调用多次，hashCode方法必须始终如一地返回同一个整数。
 * 
 * 特别注意：是重写Override equals和hashCode方法，而不是重载！ 
 */
public class HashCodeIntro {
	
	public static void main(String args[]){
		//整数的hashcode是整数值
		int i=1;
		print(i);
		//字符的hashcode是字符编码
		char c='\u0001';
		print(c);
		//double的hashcode相当复杂啊。。。
		double d=1.0;
		double d2=1.0;
		print(d);
		print(d2);
		//对象的hashcode是内存地址的一个映射
		Object o=new Object();
		Object o2=new Object();
		print(o);
		print(o2);
		
		Student s=new Student("张三",24,"清华","20101987");
		Set<Student> studentSet=new HashSet<Student>();
		studentSet.add(s);
		//s.setSchool("UCAS");
		print(studentSet.contains(new Student("张三",24,"清华","20101987")));
		
	}
	

	static void print(Object object){
		System.out.println("对象的值是:"+object);
		System.out.println("对象的hashCode值是:"+object.hashCode());
	}
	
}


