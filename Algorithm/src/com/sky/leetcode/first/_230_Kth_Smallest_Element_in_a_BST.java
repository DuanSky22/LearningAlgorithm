package com.sky.leetcode.first;

public class _230_Kth_Smallest_Element_in_a_BST {
	
	
	//========================================================
	public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        int leftSize = count(root.left);
        if( k == leftSize + 1) return root.val;
        else if (k < leftSize + 1) return kthSmallest(root.left,k);
        else return kthSmallest(root.right, k - leftSize - 1);
    }
	
	public int count(TreeNode curr){
		if(curr == null) return 0;
		return count(curr.left)+count(curr.right)+1;
	}
	
}
