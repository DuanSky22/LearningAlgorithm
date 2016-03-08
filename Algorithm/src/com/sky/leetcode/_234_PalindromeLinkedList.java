package com.sky.leetcode;
/*
 *  @author: DuanSky
 *    @time: 2015��8��23�� ����12:34:47
 * @content:
 * ��Ŀ��
 * 
	Given a singly linked list, determine if it is a palindrome.
	Follow up:
	Could you do it in O(n) time and O(1) space?
	��:
	    �ȽϾ��ʵĴ𰸣�
	    https://leetcode.com/discuss/45656/easy-understand-java-solution-o-1-space-cost
	    ����Ŀ���ѵ������ʹ�ÿռ临�Ӷȴﵽo(1)?
	  ������������Ϊ�����o(1)�ռ��ڷ�ת����
 */
class ListNode{
	int val;
	ListNode next;
	ListNode(int x){this.val=x;}
	public static ListNode generate(int[] array){
		if(array==null || array.length==0) return null;
		int length = array.length;
		ListNode res = new ListNode(array[0]), temp = res;
		for(int i=1;i<length;i++){
			temp.next = new ListNode(array[i]);
			temp = temp.next;
		}
		return res;
	}
}
public class _234_PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
        if(head==null)
        	return true;
        ListNode temp1,temp2=head;
        int num=0;
        while(temp2.next!=null){ 
        	num++;
        }
        int count=0;
        while(count<=num/2){
        	temp1=head;
        	temp2=head;
        	for(int i=0;i<=count;i++)
        		temp1=temp1.next;
        	for(int i=1;i<num-count;i++)
        		temp2=temp2.next;
        	if(temp1.val!=temp2.val)
        		return false;
        }
        
        return true;
    }
}
