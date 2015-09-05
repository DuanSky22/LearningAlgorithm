package com.njz.leetcode;

import java.util.Stack;

public class _206_ReverseLinkedList {
	
	/*
	 * 方法1---使用stack来存储这些点，再反序得到(功能可以实现，但有空间需求，同时注意指针的死循环问题)
	 */
	public static ListNode reverseList1(ListNode head) {
		if(head == null)
			return null;
		
		ListNode rs = null;
		Stack<ListNode> s = new Stack<ListNode>();
		while(head != null){
			s.push(head);
			head = head.next;
		}
		
		rs = s.pop();
		ListNode res = rs;
		while(!s.isEmpty()){
			rs.next = s.pop();
			rs = rs.next;
		}
		rs.next = null;
		return res;
	}
	
	/*
	 * 方法2---迭代计算，看指针
	 */
	public static ListNode reverseList2(ListNode head) {
		if(head==null || head.next==null)
			return head;  
        
        ListNode pre = head;  
        ListNode p = pre.next;
        pre.next = null;
        ListNode tmp = null;
        while(p != null){
        	tmp = p.next;
        	p.next = pre;
        	pre = p;
        	p = tmp;
        }
        return pre;
	}
	
	
	/*
	 * 方法3：�?�归计算
	 */
    public static ListNode reverseList3(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return head;
        
        ListNode p = head.next;
        ListNode n = reverseList3(p);
        
        head.next = null;
        p.next = head;
        return n;
    }
    
    
	public static void main(String[] args){
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);a1.next=a2;
		ListNode a3 = new ListNode(3);a2.next=a3;
		ListNode a4 = new ListNode(4);a3.next=a4;
		ListNode a5 = new ListNode(5);a4.next=a5;
		ListNode a6 = new ListNode(6);a5.next=a6;
		
		
//		System.out.println("\ntest3:");
//		ListNode rs3 = reverseList3(a1);
//		while(rs3 != null){
//			System.out.print(rs3.val + " : ");
//			rs3 = rs3.next;
//		}
		
		System.out.println("\ntest2:");
		ListNode rs2 = reverseList2(a1);
		while(rs2 != null){
			System.out.print(rs2.val + " : ");
			rs2 = rs2.next;
		}
		
		System.out.println("\ntest1:");
		ListNode rs1 = reverseList1(a1);
		while(rs1 != null){
			System.out.print(rs1.val + " : ");
			rs1 = rs1.next;
		}
	
		
	}
}
