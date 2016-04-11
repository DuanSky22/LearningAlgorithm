package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2016年3月31日 下午5:06:12
 * @content 
 */

public class _114_Flatten_Binary_Tree_to_Linked_List {
	
	public static void main(String args[]){
		_114_Flatten_Binary_Tree_to_Linked_List test = new _114_Flatten_Binary_Tree_to_Linked_List();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		test.flatten(root);
	}
	
	public void flatten(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return;
        TreeNode res = new TreeNode(0);
        flatten_(res,root);
    }  	
	
	private TreeNode flatten_(TreeNode last,TreeNode curr){
		if(curr == null) return last;
		if(curr.left == null && curr.right == null){
			last.right = curr;
			return curr;
		}
		TreeNode left = curr.left, right = curr.right;
		last.right = curr; curr.left = null; curr.right = null;
		TreeNode temp = flatten_(curr,left);
		TreeNode res = flatten_(temp,right);
		return res;
	}
}
