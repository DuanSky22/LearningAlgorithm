package com.sky.leetcode.first;

import java.util.LinkedList;
import java.util.List;

public class _236_Lowest_Common_Ancestor_of_a_Binary_Tree {
	
	public static void main(String args[]){
		_236_Lowest_Common_Ancestor_of_a_Binary_Tree test = new _236_Lowest_Common_Ancestor_of_a_Binary_Tree();
		TreeNode root = new TreeNode(1);
		TreeNode p = new TreeNode(2);
		TreeNode q = new TreeNode(3);
		root.left = p; root.right = q;
		TreeNode res = test.lowestCommonAncestor(root, p, q);
	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p == root || q == root) return root;
        List<TreeNode> ps = new LinkedList<>();
        List<TreeNode> qs = new LinkedList<>();
        getParents(root,p,ps); ps.add(0,root);
        getParents(root,q,qs); qs.add(0,root);
        int i = 0, j = 0;
        for(; i < ps.size() && j < qs.size(); i++,j++){
        	if(ps.get(i)!= qs.get(i))
        		break;
        }
        return ps.get(i-1);
    }
	
	//curr 当前正在查找的节点，假设要查找的节点一定是当前节点的子节点
	public boolean getParents(TreeNode curr,TreeNode p,List<TreeNode> parents){
		if(curr == p) return true;
		boolean left = false , right = false;
		if(curr.left != null && (left = getParents(curr.left,p,parents))){
			parents.add(0,curr.left);
		}else if(curr.right != null && (right = getParents(curr.right,p,parents))){
			parents.add(0,curr.right);
		}
		return left || right;
	}
}
