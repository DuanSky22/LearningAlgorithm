package com.sky.leetcode;

import com.sky.leetcode.util.ListNode;

  //Definition for singly-linked list.
/*Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/

public class _002_AddTwoNumbers {
	public static void main(String args[]){
		ListNode a1 = new ListNode(2);
		ListNode a2 = new ListNode(4);
		ListNode a3 = new ListNode(3);
		a1.next = a2;
		a2.next = a3;
		
		ListNode b1 = new ListNode(5);
		ListNode b2 = new ListNode(6);
		ListNode b3 = new ListNode(4);
		b1.next = b2;
		b2.next = b3;
		print(addTwoNumbers(a1,b1));
	}
	public static void print(ListNode list){
		ListNode temp=list;
		while(temp!=null){
			System.out.print(temp.val+" ");
			temp=temp.next;
		}
		System.out.println();
	}
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {      
        if(l1==null || l2==null)
        	return l1==null ? l2 : l1;
        ListNode result=null;
        int v1=l1.val;
        int v2=l2.val;
        int left=(v1+v2)%10;
        int carry=(v1+v2)/10;
        ListNode temp=new ListNode(left);
        result=temp;
        l1=l1.next;
        l2=l2.next;
        while(l1!=null && l2!=null){
        	v1=l1.val;v2=l2.val;
        	left=(carry+v1+v2)%10;
        	carry=(carry+v1+v2)/10;
        	temp.next=new ListNode(left);
        	temp=temp.next;
        	l1=l1.next;l2=l2.next;
        }
        if(l1!=null || l2!=null){
        	ListNode leftChain= l1==null ? l2 : l1;
        	if(carry==0)
        		temp.next=leftChain;
        	else{
        		while(leftChain!=null){
            		int value=leftChain.val;
            		left=(value+carry)%10;
            		carry=(value+carry)/10;
            		temp.next=new ListNode(left);
            		temp=temp.next;
            		leftChain=leftChain.next;
            	}
        		if(carry!=0){
        			temp.next=new ListNode(carry);
        		}
        	}
        }
        else if(carry!=0){
        	temp.next=new ListNode(carry);
        }
        
        return result;
        
    }
}
