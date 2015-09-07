package com.njz.leetcode;

public class _237_deleteNode {
	public static ListNode a1;
	
	public static void deleteNode(ListNode node){
		if(node == null)
			return;
		
		node.val = node.next.val;
		node.next = node.next.next;
	}
	
	public static void main(String[] args) {
		a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);a1.next=a2;
		ListNode a3 = new ListNode(3);a2.next=a3;
		ListNode a4 = new ListNode(4);a3.next=a4;
		ListNode a5 = new ListNode(5);a4.next=a5;
		ListNode a6 = new ListNode(6);a5.next=a6;
		
		ListNode a = a1;
		while(a != null){
			System.out.print(a.val + " ");
			a = a.next;
		}
		
		System.out.println("\n\nafter delete\n");
		deleteNode(a3);
		
		while(a1 != null){
			System.out.print(a1.val + " ");
			a1 = a1.next;
		}
	}

}
