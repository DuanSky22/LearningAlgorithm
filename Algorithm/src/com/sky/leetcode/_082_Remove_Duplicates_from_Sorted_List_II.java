package com.sky.leetcode;

public class _082_Remove_Duplicates_from_Sorted_List_II {
	
	public static void main(String args[]){
		_082_Remove_Duplicates_from_Sorted_List_II test = new _082_Remove_Duplicates_from_Sorted_List_II();
		ListNode head = ListNode.generate(new int[]{1,2,2,3});
		ListNode res = test.deleteDuplicates(head);
	}
	
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode res = new ListNode(0);
        ListNode tail = res,next;  //tail存放上一个不重复的元素的末尾指针
        while(head != null){
        	next = head.next;
        	while(next != null && head.val == next.val) //找到第一个不想等的元素
        		next = next.next;
        	if(head.next == next){//如果相邻的两个元素不重复，则继续找下一对
        		tail.next = head;
        		tail = head;
        		head = head.next;
        	}else{//如果相邻的两个元素重复
        		head = next;
        	}
        } tail.next = null;
        return res.next;
    }
}
