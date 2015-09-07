package com.xingkong.leetcode;


public class ListNode{
	public int val=0;
	public ListNode next=null;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return val+"";
	}

	ListNode(int x){
		setVal(x);
	}
	/**
	 * @return the val
	 */
	public int getVal() {
		return val;
	}
	/**
	 * @param val the val to set
	 */
	public void setVal(int val) {
		this.val = val;
	}
	/**
	 * @return the next
	 */
	public ListNode getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	public void setNext(ListNode next) {
		this.next = next;
	}
}