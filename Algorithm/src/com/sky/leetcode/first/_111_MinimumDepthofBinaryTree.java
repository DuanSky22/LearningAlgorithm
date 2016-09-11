/**
* @author DuanSky
* @date 2015��10��20�� ����10:53:07
* @content 
*/
package com.sky.leetcode.first;

public class _111_MinimumDepthofBinaryTree {
	public static int minDepth(TreeNode root) {
        return depth(root);
    }
	
	public static int depth(TreeNode subroot){
		if(subroot==null)
			return 0;
		else if(subroot.left!=null && subroot.right!=null)
			return Math.min(depth(subroot.left),depth(subroot.right))+1;
		else if(subroot.left==null && subroot.right!=null)
		    return depth(subroot.right)+1;
		else if(subroot.left!=null && subroot.right==null)
		    return depth(subroot.left)+1;
		else 
		    return 1;
	}
}
