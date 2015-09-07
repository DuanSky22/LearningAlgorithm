package com.xingkong.leetcode;

import java.util.ArrayList;
import java.util.List;
public class AddTwoNumbers_2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddTwoNumbers_2 addTwoNumbers_2=new AddTwoNumbers_2();
		List<ListNode> l1Array=new ArrayList<ListNode>();
		List<ListNode> l2Array=new ArrayList<ListNode>();
		int[] n1={9,9,9};
		int[] n2={1};
		ListNode l1=null;
		ListNode l1_index=null;
		for(int i=0;i<n1.length;i++){
			if(i==0){
				l1=new ListNode(n1[i]);
				l1_index=l1;
				l1Array.add(l1);
			}else{
				ListNode newNode=new ListNode(n1[i]);
				l1Array.add(newNode);
				l1_index.next=newNode;
				l1_index=l1_index.next;
			}
		}
		ListNode l2=null;
		ListNode l2_index=null;
		for(int i=0;i<n2.length;i++){
			if(i==0){
				l2=new ListNode(n2[i]);
				l2_index=l2;
				l2Array.add(l2);
			}else{
				ListNode newNode=new ListNode(n2[i]);
				l2Array.add(newNode);
				l2_index.next=newNode;
				l2_index=l2_index.next;
			}
		}
		System.out.println(l1Array);
		System.out.println(l2Array);
//		while(true){
//			System.out.print(l1.val+" ");
//			if(l1.next==null) break;
//			else l1=l1.next;
//		}
//		System.out.println();
//		while(true){
//			System.out.print(l2.val+" ");
//			if(l2.next==null) break;
//			else l2=l2.next;
//		}
		ListNode resultNode=addTwoNumbers_2.addTwoNumbers(l1, l2);
		while(true){
			System.out.print(resultNode.val+" ");
			if(resultNode.next==null) break;
			else resultNode=resultNode.next;
		}
	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head=l1;
		int ahead=0;
		while(true){
			if(l1==null)return l2;
			if(l2==null) return l1;
			if(l1.next!=null&&l2.next!=null){
				int value=l1.val+l2.val+ahead;
				int leave=value%10;//留下来的位数
				ahead=value/10;//进位
				l1.val=leave;
				l1=l1.next;
				l2=l2.next;
			}else if(l1.next==null&&l2.next==null){
				int value=l1.val+l2.val+ahead;
				int leave=value%10;//留下来的位数
				ahead=value/10;//进位
				l1.val=leave;
				if(ahead>=1){
					ListNode newListNode=new ListNode(0);
					newListNode.val=ahead;
					l1.next=newListNode;
				}
				break;
			}else if(l1.next==null){
				int value=l1.val+l2.val+ahead;
				int leave=value%10;//留下来的位数
				ahead=value/10;//进位
				l1.val=leave;
				l1.next=l2.next;
				//依次检查l1的每一位
				ListNode templ1=l1;
				while(templ1.next!=null){
					templ1=templ1.next;
					if((templ1.val+ahead)==10){
						ahead=1;
						templ1.val=0;
					}else{
						templ1.val=templ1.val+ahead;
						ahead=0;
					}
				}
				if(ahead>=1){
					ListNode newListNode=new ListNode(0);
					newListNode.val=ahead;
					templ1.next=newListNode;
				}
				break;
			}else if(l2.next==null){
				int value=l1.val+l2.val+ahead;
				int leave=value%10;//留下来的位数
				ahead=value/10;//进位
				l1.val=leave;
				//依次检查l1的每一位
				ListNode templ1=l1;
				while(templ1.next!=null){
					templ1=templ1.next;
					if((templ1.val+ahead)==10){
						ahead=1;
						templ1.val=0;
					}else{
						templ1.val=templ1.val+ahead;
						ahead=0;
					}
				}
				if(ahead>=1){
					ListNode newListNode=new ListNode(0);
					newListNode.val=ahead;
					templ1.next=newListNode;
				}
				break;
			}
			
    }
		return head;
	
	}
}
