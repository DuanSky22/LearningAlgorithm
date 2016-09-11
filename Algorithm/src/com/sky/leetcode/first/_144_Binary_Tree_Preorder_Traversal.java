package com.sky.leetcode.first;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _144_Binary_Tree_Preorder_Traversal {

	//非递归方式遍历，采用stack存储右孩子元素
	public List<Integer> preorderTraversal1(TreeNode root){
		List<Integer> res = new ArrayList<>();
		if(root == null) return res;
		Stack<TreeNode> stack = new Stack<>();
		while(root != null){
			res.add(root.val);
			if(root.right != null) stack.push(root.right);
			root = root.left;
			if(root == null && !stack.isEmpty())
				root = stack.pop();
		}
		return res;
	}
	
	//非递归方式遍历,采用stack存储左右孩子的元素
	public List<Integer> preorderTraversal0(TreeNode root){
		List<Integer> res = new ArrayList<>();
		if(root == null) return res;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode curr = stack.pop();
			res.add(curr.val);
			if(curr.right != null) stack.add(curr.right);
			if(curr.left != null) stack.add(curr.left);
		}
		return res;
	}
	
	
	//递归方式遍历
	public List<Integer> preorderTraversal(TreeNode root) {
	     List<Integer> res = new ArrayList<Integer>();
	     preorder(root,res);
	     return res;
	}

	private void preorder(TreeNode root, List<Integer> res) {
		if(root == null) return;
		res.add(root.val);
		preorder(root.left,res);
		preorder(root.right,res);
	}
}
