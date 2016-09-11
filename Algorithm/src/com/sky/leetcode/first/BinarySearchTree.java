package com.sky.leetcode.first;
/**
 * @author DuanSky
 * @date 2015年12月23日 下午10:37:37
 * @content 
 */

public class BinarySearchTree {
	
	public static void main(String args[]){
		BinarySearchTree bst=new BinarySearchTree();
		for(int i=0;i<10;i++){
			bst.add(i*(5-i));
		}
		bst.trverse();
	}
	
	private Node root;

	public void trverse(){
		if(root!=null){
			trverse(root.left);
			System.out.print(" "+root.val+" ");
			trverse(root.right);
		}
	}
	
	private void trverse(Node subroot){
		if(subroot!=null){
			trverse(subroot.left);
			System.out.print(" "+subroot.val+" ");
			trverse(subroot.right);
		}
	}
	
	public boolean exists(int x){
		return exists(root,x);
	}
	
	public boolean exists(Node subroot,int x){
		if(subroot==null) return false;
		else if(subroot.left==null && subroot.right==null) return subroot.val==x;
		else if(subroot.val<x) return exists(subroot.right,x);
		else return exists(subroot.left,x);
	}
	
	public void add(int x){
		if(root==null){ //如果只有一个元素，则将该元素置为根。
			root=new Node(x);
		}
		else{ //否则查找到该元素插入的位置
			Node pos=find(x);
			if(pos.val<x)
				pos.right=new Node(x);
			else
				pos.left=new Node(x);
		}
	}
	
	public Node find(int x){
		return find(root,x);
	}
	
	private Node find(Node subroot, int x){
		if( subroot==null || (subroot.left==null && subroot.right==null) || subroot.val==x) //如果为空，或者只有一个元素，或者找到了这个元素
			return subroot;
		if(subroot.val<x) //在右边查找
			return find(subroot.right,x);
		else
			return find(subroot.left,x);
	}
	
	public class Node{
		Node left;
		Node right;
		int val;
		Node(int val){
			this.val=val;
		}
	}

}
