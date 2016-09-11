package com.sky.leetcode.first;

import java.util.Stack;

public class _098_Validate_Binary_Search_Tree {
	
	
	
	//=========================================================
	public boolean isValidBST1(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root ;
        TreeNode pre = null ;           
        while (!stack.isEmpty() || cur != null) {               
            if (cur != null) {
                stack.push(cur);
                cur = cur.left ;
            } else {                
                TreeNode p = stack.pop() ;
                if (pre != null && p.val <= pre.val) {                      
                    return false ;
                }                   
                pre = p ;                       
                cur = p.right ;
            }
        }
        return true ; 
    }
	
	//=========================================================
	public boolean isValidBST0(TreeNode root){
		return isValidBST0(root,Long.MIN_VALUE,Long.MAX_VALUE);
	}
	private boolean isValidBST0(TreeNode root, long minValue, long maxValue) {
		if(root == null) return true;
		if(root.val >= maxValue || root.val <= minValue) return false;
		return isValidBST0(root.left,minValue,root.val) && isValidBST0(root.right,root.val,maxValue);
	}



	//采用定义来做===========================================================
	public boolean isValidBST(TreeNode root) {
		if(root == null) return true;
		long leftMax = getMaxNumber(root.left);
		long rightMin = getMinNumber(root.right);
		return leftMax < root.val && root.val < rightMin && isValidBST(root.left) && isValidBST(root.right); 
    }
	
	
	public long getMaxNumber(TreeNode curr){
		if(curr == null) return Long.MIN_VALUE;
		long left = getMaxNumber(curr.left);
		long right = getMaxNumber(curr.right);
		return Math.max(left, Math.max(right, curr.val));
	}
	
	public long getMinNumber(TreeNode curr){
		if(curr == null) return Long.MAX_VALUE;
		long left = getMinNumber(curr.left);
		long right = getMinNumber(curr.right);
		return Math.min(left, Math.min(right, curr.val));
	}
	
	
}
