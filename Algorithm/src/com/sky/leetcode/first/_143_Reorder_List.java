package com.sky.leetcode.first;

public class _143_Reorder_List {

	public static void main(String args[]){
		_143_Reorder_List test = new _143_Reorder_List();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		//head.next.next.next = new ListNode(4);
		test.reorderList(head);
	}
	
	public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        ListNode middle = getMiddle(head);
        ListNode second = reverse(middle);
        createLink(head,second);
    }

	private void createLink(ListNode first, ListNode second) {
		ListNode f = first, s = second;
		while(f != null && s != null){
			f = first.next; s = second.next;
			first.next = second;second.next = f;
			if(f == s || f.next == s) break;
			first = f; second = s;
		} 
	}

	private ListNode reverse(ListNode curr) {
		ListNode tail = null, head = curr, next = curr;
		while(head != null){
			next = head.next;
			head.next = tail;
			tail = head;
			head = next;
		}
		return tail;
	}

	private ListNode getMiddle(ListNode head) {
		ListNode slow = head, fast = head.next;
		while(fast != null){
			slow = slow.next;
			fast = fast.next == null ? null : fast.next.next;
		}
		return slow;
	}
}
