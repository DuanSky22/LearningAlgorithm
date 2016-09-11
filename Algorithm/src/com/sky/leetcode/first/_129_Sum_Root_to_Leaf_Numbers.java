package com.sky.leetcode.first;

public class _129_Sum_Root_to_Leaf_Numbers {
	
	
	public static void main(String args[]){
		char a = '0';
		int b = a;
		System.out.println(1+b);
	}
	
	public int sumNumbers(TreeNode root) {
        return sumNumbers(root,"");
    }
	
	public int sumNumbers(TreeNode curr, String s){
		if(curr == null) return 0;
		if(curr != null && (curr.left == null && curr.right == null)) //到达叶子节点
			return Integer.parseInt(s+curr.val);
		return sumNumbers(curr.left, s+curr.val) + sumNumbers(curr.right,s+curr.val);
	}
	
	public int sumNumbers(TreeNode curr, int sub){
		if(curr == null) return 0;
		if(curr.left == null && curr.right == null) return sub * 10 + curr.val;
		return sumNumbers(curr.left,sub * 10 + curr.val) + sumNumbers(curr.right,sub * 10 + curr.val);
	}
}
