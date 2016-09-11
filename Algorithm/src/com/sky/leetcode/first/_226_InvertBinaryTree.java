/**
* @author DuanSky
* @date 2015��9��28�� ����11:12:19
* @content 
*/
package com.sky.leetcode.first;

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
