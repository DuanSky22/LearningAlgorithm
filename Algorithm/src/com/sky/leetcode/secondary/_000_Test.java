package com.sky.leetcode.secondary;


/**
 * Created by SkyDream on 2016/9/7.
 */
public class _000_Test {
    public static void main(String args[]){
        Integer a = 1;
        int b = 1;
        System.out.println(a < b);
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        boolean left = isValidBST(root.left);
        boolean right = isValidBST(root.right);
        if(left && right){
            Integer leftMax = max(root.left);
            Integer rightMin = min(root.right);
            return (leftMax == null ? true : (leftMax < root.val)) && (rightMin == null ? true : (rightMin > root.val));
        }
        return false;
    }

    public Integer max(TreeNode root){
        if(root == null) return null;
        while(root.right != null) root = root.right;
        return root.val;
    }

    public Integer min(TreeNode root){
        if(root == null) return null;
        while(root.left != null) root = root.left;
        return root.val;
    }

    private class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private int val;
    }
}
