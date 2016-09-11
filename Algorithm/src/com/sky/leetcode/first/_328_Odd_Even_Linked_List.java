package com.sky.leetcode.first;

public class _328_Odd_Even_Linked_List {
	

	//无需判断过程
	public ListNode oddEvenList0(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode oddTail = head, evenTail = head.next, evenHead = evenTail;
		while(evenTail != null && evenTail.next != null){
			oddTail.next = oddTail.next.next;
			oddTail = oddTail.next;
			evenTail.next  = evenTail.next.next;
			evenTail = evenTail.next;
		}oddTail.next = evenHead;
		return head;
	}
	
	//根据奇偶判断下一个元素加入到哪个链表中
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode oddHead = head, oddTail = head;
        ListNode evenHead = head.next, evenTail = head.next;
        int counter = 3; head = head.next.next;
        while(head != null){
        	if(counter % 2 == 1){//如果当前的元素是奇数
        		oddTail.next = head;
        		oddTail = oddTail.next;
        	}else{
        		evenTail.next = head;
        		evenTail = evenTail.next;
        	}
        	counter++; head = head.next;
        } oddTail.next = evenHead; evenTail.next = null;
        return oddHead;
    }
}
