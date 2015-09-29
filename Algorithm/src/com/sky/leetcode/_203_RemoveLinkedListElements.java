/**
* @author DuanSky
* @date 2015年9月28日 下午10:19:02
* @content 
*/
package com.sky.leetcode;

import com.sky.leetcode.util._ListNode;

public class _203_RemoveLinkedListElements {

	public _ListNode removeElements(_ListNode head, int val) {
        if(head==null)
            return head;
        _ListNode former=head;
        _ListNode latter=new _ListNode(-1);
        latter.next=head;
        _ListNode result=latter;
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
