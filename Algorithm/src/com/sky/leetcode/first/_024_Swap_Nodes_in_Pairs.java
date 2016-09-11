package com.sky.leetcode.first;
/**
 * @author DuanSky
 * @date 2015年12月24日 下午4:52:52
 * @content 
 * 一次成功，nice ~.~
 */

public class _024_Swap_Nodes_in_Pairs {
	public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode front=new ListNode(0);
        ListNode tail=front;
        tail.next=head;
        
        while(head!=null){
        	if(head.next==null){ //没有元素剩下或者只剩下最后一个元素时，直接将该元素添加到末尾即可。整个交换过程结束。
        		tail.next=head;
        		break;
        	}else{ 
        		ListNode first=head; //现在开始交换这两个元素
        		head=head.next.next;
        		ListNode second=first.next;
        		second.next=first;
        		first.next=null;
        		tail.next=second;
        		tail=first;
        	}
        }
        return front.next;
    }
}
