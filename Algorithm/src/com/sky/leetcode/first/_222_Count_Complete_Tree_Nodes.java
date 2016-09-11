package com.sky.leetcode.first;


public class _222_Count_Complete_Tree_Nodes {
	
	
	//===========================================================
	//针对完全二叉树
	
	public int countNodes0(TreeNode root){
		if(root == null) return 0;
		int res = 0;
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		if(leftHeight != rightHeight){
			res += 1 << rightHeight;
			res += countNodes0(root.left);
		}else{
			res += 1 << leftHeight;
			res += countNodes0(root.right);
		}
		return res;
	}
	public int height(TreeNode curr){
		int h = 0;
		while(curr != null){
			h++;
			curr = curr.left;
		}
		return h;
	}

	//===========================================================
	//通用版本
	public int countNodes(TreeNode root) {
		if(root == null) return 0;
		return 1 + countNodes(root.left) + countNodes(root.right);
	}
	
}
