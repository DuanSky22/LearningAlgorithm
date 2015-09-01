package com.sky.learningJava.Collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListTest {

	public static void main(String args[]){
		//List 线性表是用来存储有序可重复的元素的集合。支持位置索引和双向游走的迭代器
		/*
		 * ArrayList 数组线性表是采用数组来存储元素的列表。如果需要随机访问元素，
		 * 而元素的增加只在末尾进行，那么数组线性表是比较高效的。
		 * LinkedList 链式线性表是采用链表来存储元素的列表。它的优点是对元素的动态添加
		 * 比较高效，但是随机访问能力较差。如果需要动态在指定位置插入元素，那么链式线性表是比较高效的。
		 */
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		addElements(arrayList,10);
		printElements(arrayList);
		arrayList.removeAll(arrayList);
		//System.out.println(arrayList.size());
		ArrayList<Person> personList=new ArrayList<Person>();
		for(int i=0;i<10;i++){
			Person p=new Person("a"+i,20); //线性表中存储的是引用p。如果p的内容改变，则线性表中的内容也会跟着改变。
			personList.add(p);
			p.setAge(20+i);
		}
		/*
		 * 注意，ArrayList的clone()方法以及Collections的静态方法copy
		 * 都是浅拷贝，如果是对象，拷贝的就是对象的引用。那么只要两个表中有任何一个对象被修改，
		 * 另外一个也会受到影响。
		 * 此外，add(),addAll()方法都是浅拷贝，拷贝的是对象的引用。
		 */
		ArrayList<Person> personListCopy=new ArrayList<Person>();
		personListCopy=(ArrayList<Person>) personList.clone();
		
		Collections.copy(personListCopy, personList);
		//personListCopy.addAll(personList);
//		for(int i=0;i<10;i++){
//			personListCopy.get(i).setAge(30);
//		}
		printElements(personList);
//		printElements(personListCopy);
		//反转链表
		Collections.reverse(personList);
		printElements(personList);
		//随机排列
		Collections.shuffle(personList);
		printElements(personList);
		//排序
		Collections.sort(personList);
		printElements(personList);
		
		LinkedList<String> linkedList=new LinkedList<String>();
		
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
