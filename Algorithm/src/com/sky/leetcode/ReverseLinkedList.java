/**
* @author DuanSky
* @date 2015年9月30日 下午9:45:28
* @content 
*/
package com.sky.leetcode;


public class ReverseLinkedList {
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
