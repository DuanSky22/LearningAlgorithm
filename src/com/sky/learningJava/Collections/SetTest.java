package com.sky.learningJava.Collections;


import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {

	public static void main(String args[]){
        /*
         * set接口继承与Collection接口。
         * AbstractSet是实现Set接口的抽象类，表示的是不重复的元素的集合。
         * HashSet
         * HashSet是实现AbstractSet的具体类，它内部存储的元素是不重复的无序的元素集合。
         * hashSet元素添加的顺序和元素存储的顺序，或者元素之间大小关系都无关。
         */
        Set<Integer> hashSet=new HashSet<Integer>();
        addElements(hashSet, 10);
        printElements(hashSet);
        /*
         * LinkedHashSet
         * LinkedHashSet继承与HashSet，也是具体类。与HashSet的区别是：
         * 它元素存储的顺序即为元素插入的顺序。
         * 
         */
        LinkedHashSet<Integer> linkedHashSet=new LinkedHashSet<Integer>();
        addElements(linkedHashSet,10);
        printElements(linkedHashSet);
        /*
         * SortedSet 是继承于Set的接口。
         * NavigableSet又扩展了SortedSet接口的接口。
         * TreeSet实现了NavigableSet接口，它与前面两种set集合不同的是
         * TreeSet中的元素是可以比较的，且按照元素的比较顺序排序，是有序的。
         * TreeSet有两种初始化方法：
         * 1. 不带参数或者指定集合作为参数的初始化，要求集合中的元素必须实现了Comparable接口
         * 2. 传入指定的比较器对象初始化。
         * 
         */
        TreeSet<Integer> treeSet=new TreeSet<Integer>();
        addElements(treeSet, 20);
        printElements(treeSet);
	}
	
	public static void addElements(Collection c,int n){
		if(n<=0)
			return;
		System.out.println("添加的元素的顺序为：");
		for(int i=0;i<n;i++){
			Object e=(Object)(new Random().nextInt(100));
			System.out.print(e+" ");
			c.add(e);
		}
		System.out.println();
	}
	
	public static void printElements(Collection c){
		System.out.println("元素实际存储的顺序为：");
		Iterator iterator=c.iterator();
		while(iterator.hasNext()){
			System.out.print(iterator.next()+" ");
		}
		System.out.println();	
	}
}
