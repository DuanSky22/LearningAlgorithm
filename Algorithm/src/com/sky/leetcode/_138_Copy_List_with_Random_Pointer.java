package com.sky.leetcode;

import java.util.HashMap;

public class _138_Copy_List_with_Random_Pointer {
	
	public static void main(String args[]){
		_138_Copy_List_with_Random_Pointer test = new _138_Copy_List_with_Random_Pointer();
		RandomListNode head = new RandomListNode(-1);
		RandomListNode next = new RandomListNode(-1);
		head.next = next; next.random = head;
		RandomListNode res = test.copyRandomList(head);
	}
	
	 public RandomListNode copyRandomList(RandomListNode head) {
		 return copyRandomList(head,new HashMap<String, RandomListNode>());
	 }

	private RandomListNode copyRandomList(RandomListNode head,HashMap<String, RandomListNode> cache) {
		if(head == null) return head;
		String key = head.label +"#" + ( head.random == null ? "NULL" : head.random.label+"" ) + "#"+ ( head.next == null ? "NULL" : head.next.label+"");
		if(cache.containsKey(key))
			return cache.get(key);
		else{
			RandomListNode res = new RandomListNode(head.label);
			cache.put(key, res);
			res.next = copyRandomList(head.next,cache);
			res.random = copyRandomList(head.random,cache);
			return res;
		}
	}
	 
}
