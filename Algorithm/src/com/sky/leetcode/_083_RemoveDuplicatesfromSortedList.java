package com.sky.leetcode;

public class _083_RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode former=head;
        ListNode latter=head;
        while(former.next!=null){
            former=former.next;
            if(latter.val==former.val){
                latter.next=former.next;
            }
            else{
                latter=latter.next;
            }
        }
        return head;
    }
}
