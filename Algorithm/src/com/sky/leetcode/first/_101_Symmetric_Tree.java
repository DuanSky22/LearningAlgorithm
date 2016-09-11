package com.sky.leetcode.first;
/**
 * @author DuanSky
 * @date 2016年3月19日 下午3:25:22
 * @content 
 */

public class _101_Symmetric_Tree {
	public boolean isSymmetric(TreeNode root) {
		if(root == null) return true;
        return core(root.left,root.right);
    }
	
	public boolean core(TreeNode left,TreeNode right){
		if(left==null && right == null) return true;
		if( left != null && right !=null && left.val==right.val){
			return core(left.left,right.right) && core(left.right,right.left);
		}
		return false;
	}
}
