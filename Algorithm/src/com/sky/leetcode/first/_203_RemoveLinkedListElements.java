/**
* @author DuanSky
* @date 2015��9��28�� ����10:19:02
* @content 
*/
package com.sky.leetcode.first;


public class _203_RemoveLinkedListElements {

	public ListNode removeElements(ListNode head, int val) {
        if(head==null)
            return head;
        ListNode former=head;
        ListNode latter=new ListNode(-1);
        latter.next=head;
        ListNode result=latter;
        while(former!=null){
            if(former.val==val){
                former=former.next;
                latter.next=former;
            }
            else{
                former=former.next;
                latter=latter.next;
            }
        }
        return result!=null ? result.next : result;
    }
}
