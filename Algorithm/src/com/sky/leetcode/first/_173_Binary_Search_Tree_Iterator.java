package com.sky.leetcode.first;

import java.util.Stack;

public class _173_Binary_Search_Tree_Iterator {
	
	public class BSTIterator {

		Stack<TreeNode> stack = new Stack<>();
	    public BSTIterator(TreeNode root) {
	        while(root != null){
	        	stack.push(root);
	        	root = root.left;
	        }
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return !stack.isEmpty();
	    }

	    /** @return the next smallest number */
	    public int next() {
	        TreeNode curr = stack.pop();
	        int res = curr.val;
	        curr = curr.right;
	        while(curr != null){
	        	stack.push(curr);
	        	curr = curr.left;
	        }
	        return res;
	    }
	}
}
