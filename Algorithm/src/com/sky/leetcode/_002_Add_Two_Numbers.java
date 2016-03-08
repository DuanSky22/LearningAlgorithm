package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2016年3月1日 上午9:48:33
 * @content 
 * [0,8,6,5,6,8,3,5,7]
[6,7,8,0,8,5,8,9,7]
 */

public class _002_Add_Two_Numbers {
	
	public static void main(String args[]){
		_002_Add_Two_Numbers test = new _002_Add_Two_Numbers();
		ListNode l1 = ListNode.generate(new int[]{0,8,6,5,6,8,3,5,7});
		ListNode l2 = ListNode.generate(new int[]{6,7,8,0,8,5,8,9,7});
		ListNode l = test.addTwoNumbers(l1, l2);
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode res = new ListNode(0),tail = res;
        int carry = 0, left = 0, temp = 0, t1 = 0, t2 = 0;
        while(l1!=null || l2!=null){
        	t1 = l1 == null ? 0 : l1.val;
        	t2 = l2 == null ? 0 : l2.val;
    		temp = t1 + t2 + carry;
    		carry = temp / 10;
    		left = temp % 10;
    		tail.next = new ListNode(left);
    		tail = tail.next;
    		l1 = l1 == null ? null : l1.next;
    		l2 = l2 == null ? null : l2.next;
        }
        if(carry == 1) tail.next = new ListNode(1);//MISTAKE 注意最后一定要判断一下carry的情况！！
        return res.next;
    }

}
