package com.sky.learningJava.Collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;

public class MapTest {
	
	public static void main(String args[]){
		/*
		 * Map接口是键值对的映射的集合。
		 * AbstractMap是实现Map接口的抽象类
		 * SortedMap是继承Map接口的可排序的图接口
		 * NavigableMap是继承SortedMap的接口
		 */
		
		/*
		 * HashMap是实现AbstractMap的具体类
		 * 键的排序是无序的。与插入的顺序无关，与元素之间的大小比较也无关。
		 */
		HashMap<String,Integer> hashMap=new HashMap<String,Integer>();
		addElements(hashMap);
		printElements(hashMap);
		/*
		 * LinkedHashMap是继承HashMap的具体类
		 * 它的元素是按照指定规则排序的。
		 * 默认情况下，元素存储的顺序是元素插入的顺序；
		 * 用户还可以指定按照元素最后一次被访问的顺序来排序。
		 * 最后一次被访问的先后顺序来排序。最近进当前时刻被访问的排在后面，越是长时间不访问的排在前面
		 */
		LinkedHashMap<String,Integer> linkedHashMap=new LinkedHashMap<String,Integer>();
		addElements(linkedHashMap);
		printElements(linkedHashMap);
		
		LinkedHashMap<String,Integer> linkedHashMap2=new LinkedHashMap<String,Integer>(10,0.75f,true);
		addElements(linkedHashMap2);
		linkedHashMap2.put("k00", 1);
		linkedHashMap2.put("k01", 1);
		linkedHashMap2.put("k02", 1);
		linkedHashMap2.put("k03", 1);
		linkedHashMap2.put("k04", 1);
		linkedHashMap2.put("k05", 1);
		linkedHashMap2.put("k06", 1);
		linkedHashMap2.put("k07", 1);
		linkedHashMap2.put("k08", 1);
		linkedHashMap2.put("k09", 1);
		linkedHashMap2.put("k00", 1);
		printElements(linkedHashMap2);
		
		/*
		 * TreeMap是实现NavigableMap的具体类
		 * 他可以按照自然顺序或者比较器的构造的规则对插入的Key进行排序。
		 * 要求插入的元素的key是可以比较的，或者在构造TreeMap时，需要传入
		 * 实现Compator接口类的对象
		 */
		//默认情况下，按照自然顺序排序。即实现Comparable接口的key值来排序
		TreeMap<String,Integer> treeMap=new TreeMap<String,Integer>();
		addElements(treeMap);
		printElements(treeMap);
		
	}
	
	public static void addElements(Map<String,Integer> map){
		addElements(map,10);
	}
	
	public static void addElements(Map<String,Integer> map,int n){
		if(n<=0)
			return;
		System.out.print("插入元素的顺序：");
		for(int i=0;i<n;i++){
			String key="k"+new Random().nextInt(10)+i;
			Integer value=i;
			map.put(key, value);
			System.out.print("["+key+":"+value+"]");
		}
		System.out.println();
	}
	public static void printElements(Map<String,Integer> map){
		System.out.print("实际存储的顺序：");
		for(Entry<String,Integer> entry : map.entrySet()){
			String key=entry.getKey();
			int value=entry.getValue();
			System.out.print("["+key+":"+value+"]");
		}
		System.out.println();
		System.out.println();
	}

}
