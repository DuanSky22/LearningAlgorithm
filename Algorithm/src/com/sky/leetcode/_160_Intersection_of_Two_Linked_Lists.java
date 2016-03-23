package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2016年3月16日 下午3:59:43
 * @content 
 */

public class _160_Intersection_of_Two_Linked_Lists {
	
	public ListNode getIntersectionNode_(ListNode headA,ListNode headB){
		if(headA == null || headB == null) return null;
		ListNode temp1 = headA, temp2 = headB;
		while(temp1!=null && temp2!=null && temp1!=temp2){
			temp1 = temp1.next;
			temp2 = temp2.next;
			if(temp1 == temp2) break;
			if(temp1.next == null) temp1 = headB;
			if(temp2.next == null) temp2 = headA;
		}
		return temp2;
	}
	
	//先得到两个链表的长度，对齐，然后齐头并进往后遍历查找。 1ms 99.56%
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null) return null;
		int sizeA = 1, sizeB = 1, i = 0;
		ListNode temp1 = headA, temp2 = headB;
		while(temp1.next!=null){
			sizeA ++;
			temp1 = temp1.next;
		}
		while(temp2.next!=null){
			sizeB ++;
			temp2 = temp2.next;
		}
		if(temp1 != temp2) return null; //判断是否交叉
		temp1 = headA;temp2 = headB;
		if(sizeA > sizeB)
			while(i++ < sizeA - sizeB) temp1 = temp1.next;
		else if(sizeA < sizeB)
			while(i++ < sizeB - sizeA) temp2 = temp2.next;
		while(true){
			if(temp1 == temp2) break;
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		return temp1;
    }

}
