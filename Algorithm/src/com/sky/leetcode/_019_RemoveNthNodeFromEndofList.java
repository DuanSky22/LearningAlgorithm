/**
* @author DuanSky
* @date 2015年10月21日 上午9:59:43
* @content 
*/
package com.sky.leetcode;

public class _019_RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode temp=head;
		int counter=0;
		while(temp!=null){
			temp=temp.next;
			counter++;
		}
		if(n>counter)
			return head;
		else if(n==counter)
			return head.next;
		int i=0;
		ListNode remove=head.next;
		ListNode before=head;
		while(i++<counter-n-1){
			remove=remove.next;
			before=before.next;
		}
		before.next=remove.next;
		return head;
		
	}
}
