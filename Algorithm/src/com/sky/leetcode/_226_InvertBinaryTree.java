/**
* @author DuanSky
* @date 2015年9月28日 下午11:12:19
* @content 
*/
package com.sky.leetcode;

public class _226_InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
        if(root!=null){
                TreeNode temp=root.left;
                root.left=root.right;
                root.right=temp;
                invertTree(root.left);
                invertTree(root.right);
        }
        return root;
    }
}
