package com.sky.leetcode.first;

public class _021_MergeTwoSortedLists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null || l2==null)
            return l1==null ? l2 : l1;
        ListNode head=new ListNode(1);
        ListNode temp=head;
        ListNode temp1=l1;
        ListNode temp2=l2;
        while(temp1!=null && temp2!=null){
            if(temp1.val<=temp2.val){
                temp.next=temp1;
                temp1=temp1.next;
            }
            else{
                temp.next=temp2;
                temp2=temp2.next;
            }
            temp=temp.next;
        }
        temp.next= temp1==null ? temp2 : temp1;
        return head.next;
    }
}
