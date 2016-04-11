package com.sky.leetcode;

public class _110_Balanced_Binary_Tree {
	
	
	//==========================================================================
	public boolean isBalanced0(TreeNode root){
		return heightWithFlag(root) != -1;
	}
	public int heightWithFlag(TreeNode curr){
		if(curr == null) return 0;
		int leftHeight = heightWithFlag(curr.left);
		if(leftHeight == -1) return -1;
		int rightHeight = heightWithFlag(curr.right);
		if(rightHeight == -1) return -1;
		return Math.abs(leftHeight - rightHeight) <= 1 ? Math.max(leftHeight, rightHeight) + 1 : -1;
	}
	
	//==========================================================================
	public boolean isBalanced(TreeNode root) {
      if(root == null) return true;
      int leftHeight = height(root.left);
      int rightHeight = height(root.right);
      boolean isLeft = isBalanced(root.left);
      boolean isRight = isBalanced(root.right);
      return Math.abs(leftHeight - rightHeight) <= 1 && isLeft && isRight;
    }

	private int height(TreeNode curr) {
		if(curr == null) return 0;
		int left = height(curr.left);
		int right = height(curr.right);
		return Math.max(left, right)+1;
	}
}
