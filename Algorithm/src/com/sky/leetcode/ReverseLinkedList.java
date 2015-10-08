/**
* @author DuanSky
* @date 2015年9月30日 下午9:45:28
* @content 
*/
package com.sky.leetcode;

import com.sky.leetcode.util._ListNode;

public class ReverseLinkedList {
	public _ListNode reverseList(_ListNode head) {
		if(head==null || head.next==null)
			return head;
		_ListNode fast=head;
		_ListNode slow=head;
		_ListNode middle=head;
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
