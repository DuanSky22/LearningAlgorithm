/**
* @author DuanSky
* @date 2015��9��30�� ����9:45:28
* @content 
*/
package com.sky.leetcode.first;


public class _206_ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		if(head==null || head.next==null)
			return head;
		ListNode fast=head;
		ListNode slow=head;
		ListNode middle=head;
		fast=fast.next;
		middle=fast;
		head.next=null;
		while(fast!=null){
			fast=fast.next;
			middle.next=slow;
			slow=middle;
			middle=fast;
		}
        return slow;
    }
}
