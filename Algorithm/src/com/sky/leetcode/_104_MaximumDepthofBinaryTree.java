/**
* @author DuanSky
* @date 2015年9月28日 下午9:37:30
* @content 
*/
package com.sky.leetcode;

  //Definition for a binary tree node.
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
 
public class _104_MaximumDepthofBinaryTree {
	public int maxDepth(TreeNode root) {
        if(root!=null){
        	return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
        }
        else
        	return 0;
    }
}
