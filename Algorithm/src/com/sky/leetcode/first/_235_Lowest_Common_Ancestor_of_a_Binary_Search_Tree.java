package com.sky.leetcode.first;

public class _235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(p.val > q.val){
			TreeNode temp = p;
			p = q;
			q = temp;
		}
		return lowestCommonAncestor0(root,p,q);
    }

	private TreeNode lowestCommonAncestor0(TreeNode root, TreeNode p, TreeNode q) {
		if(p.val <= root.val && q.val >= root.val) return root;
		else if(q.val < root.val) return lowestCommonAncestor0(root.left,p,q);
		else return lowestCommonAncestor0(root.right,p,q);
	}
}
