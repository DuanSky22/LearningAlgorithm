package com.sky.leetcode.first;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _145_Binary_Tree_Postorder_Traversal {
	
	
	public List<Integer> postorderTraversal0(TreeNode root){
		List<Integer> list = new LinkedList<Integer>();
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root); TreeNode curr;
		while(!stack.isEmpty()){
			curr = stack.pop();
			list.add(0,curr.val);
			if(curr.left != null) stack.push(curr.left);
			if(curr.right != null) stack.push(curr.right);
		}
		return list;
	}

	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        postorder(root,list);
        return list;
    }

	private void postorder(TreeNode root, List<Integer> list) {
		if(root == null) return;
		postorder(root.left,list);
		postorder(root.right,list);
		list.add(root.val);
	}
}
