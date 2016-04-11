package com.sky.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _094_Binary_Tree_Inorder_Traversal {
	
	public static void main(String args[]){
		_094_Binary_Tree_Inorder_Traversal test = new _094_Binary_Tree_Inorder_Traversal();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2); root.left.right = new TreeNode(3);
		System.out.println(test.inorderTraversal0(root));
	}
	//非递归版本
	public List<Integer> inorderTrversal1(TreeNode root){
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<>();
		while(root != null || !stack.isEmpty()){
			while(root != null){
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			list.add(root.val);
			root = root.right;
		}
		return list;
	}

	//非递归版本
	public List<Integer> inorderTraversal0(TreeNode root){
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		while(root !=null || !stack.isEmpty()){
			if(root == null){
				root = stack.pop();
				list.add(root.val);
				root = root.right;
			}
			if(root != null && root.left == null){ //当前元素的左子树为0
				list.add(root.val);
				root = root.right;
			}else if(root != null){
				stack.push(root);
				root = root.left;
			}
		}
		return list;
	}
	
	//递归版本
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root,res);
        return res;
    }

	private void inorder(TreeNode root, List<Integer> res) {
		if(root == null) return;
		inorder(root.left,res);
		res.add(root.val);
		inorder(root.right,res);
	}
}
