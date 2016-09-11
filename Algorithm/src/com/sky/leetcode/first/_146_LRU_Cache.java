package com.sky.leetcode.first;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class _146_LRU_Cache {
	
	public static void main(String args[]){
		LRUCache cache = new LRUCache(2);
		cache.set(2, 1); cache.set(1, 1);
		System.out.println(cache.get(2));
		cache.set(4, 1);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
	}
	
	static class LRUCache{
		CacheNode head;
		CacheNode tail;
		int capacity;
		Map<Integer,CacheNode> cache = new HashMap<Integer,CacheNode>();
		
		private void removeFirst(){//删掉第一个元素（最老的元素）
			if(head != null){
				head = head.after;
				if(head != null) head.before = null;
				else tail = null;
			}
		}
		private void addLast(CacheNode node){
			if(tail != null){
				tail.after = node;
				node.before = tail;
				tail = node;
			}else{//如果初始链表为空
				head = node;
				tail = node;
			}
		}
		private void change(CacheNode node){//将当前的元素（这个元素一定存在于链表中）挑选出来加入到链表的尾部
			if(head == tail || node == tail) return; //如果只有一个元素，或者当前访问的元素就在尾部，则不移动任何元素
			if(head == node){//如果需要移动的元素是头部元素
				head = head.after;
				head.before = null;
				tail.after = node;
				node.before = tail;
				node.after = null;
				tail = tail.after;
			}else{
				CacheNode before = node.before, after = node.after;
				before.after = node.after;
				after.before = node.before;
				tail.after = node;
				node.before = tail;
				tail = tail.after;
			}
			
		}
		
		public LRUCache(int capacity) {
	        this.capacity = capacity;
	    }
	    
	    public int get(int key) {
	        if(cache.containsKey(key)){
	        	change(cache.get(key));
	        	return cache.get(key).value;
	        }
	        return -1;
	    }
	    
	    public void set(int key, int value) {
	        if(cache.containsKey(key)){
	        	change(cache.get(key));
	        	cache.get(key).value = value;
	        }else{
	        	if(cache.size() == capacity){//需要移除元素
	        		cache.remove(head.key);
		        	this.removeFirst();
	        	}
	        	CacheNode node = new CacheNode(key,value);
	        	cache.put(key, node);
	        	this.addLast(node);
	        }
	    }
		
		class CacheNode{
			int key;
			int value;
			CacheNode before;
			CacheNode after;
			CacheNode(int key,int value){
				this.key = key;
				this.value = value;
			}
		}
	}
	/*
	 * 采用链表的形式存储最近访问的元素。链表头表示最近访问的元素，链表尾表示最远访问的元素
	 * 插入和删除的复杂度仍然为o(n)
	 */
	static class LRUCache_2{
		private Map<Integer,Integer> cache = new HashMap<>();
		private List<Integer> list = new LinkedList<>();
		private int capacity = 0;
		
		public LRUCache_2(int capacity) {
	       this.capacity = capacity; 
	    }
	    
	    public int get(int key) {
	        if(cache.containsKey(key)){
	        	list.remove(list.indexOf(key));//o(n)
	        	list.add(key); 
	        	return cache.get(key);
	        }
	        return -1;
	    }
	    
	    public void set(int key, int value) {
	        if(cache.containsKey(key) || cache.size() < capacity){
	        	cache.put(key, value);
	        	int i = 0;
	        	if((i = list.indexOf(key))!=-1)
	        		list.remove(i);//o(n)
	        }
	        else{//需要删除元素
	        	cache.remove(list.get(list.size()-1));
	        	list.remove(list.size()-1);
	        }
        	cache.put(key, value);
	        list.add(key);
	    }
	}

	/*
	 * 采用一个map来实现，map中存入key值以及key值对应的时间戳。主要是每次在删除元素的时候，需要遍历
	 * map中的所有元素来选择最老的元素进行删除。
	 */
	static class LRUCache_1 {
		
		private Map<Integer,Integer> cache = new HashMap<>();
		private TreeMap<Integer,Long> state = new TreeMap<>();
		private static long TIMESTAMP = 0;
		private int capacity = 0;
		
		public LRUCache_1(int capacity) {
			this.capacity = capacity;
		}

		public int get(int key) {
			TIMESTAMP++;
			if(cache.containsKey(key)){
				state.put(key, TIMESTAMP);
				return cache.get(key);
			}
			return -1;
		}

		public void set(int key, int value) {
			TIMESTAMP++;
			if(cache.containsKey(key) || cache.size() < capacity){//如果插入的元素存在，或者缓存区容量够用，则直接替换该元素
				cache.put(key, value);
				state.put(key, TIMESTAMP);
			}else{//需要考虑删除元素,找到timestamp最小的然后删掉
				long min = Long.MAX_VALUE; int deleteKey = 0;
				for(Entry<Integer,Long> entry : state.entrySet()){
					if(entry.getValue() < min){
						min = entry.getValue();
						deleteKey = entry.getKey();
					}
				}
				cache.remove(deleteKey);
				state.remove(deleteKey);
				cache.put(key, value);
				state.put(key, TIMESTAMP);
			}
		}
	}

}
