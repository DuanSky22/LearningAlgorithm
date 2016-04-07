package com.sky.leetcode;

public class _108_Convert_Sorted_Array_to_Binary_Search_Tree {
	
	public static void main(String args[]){
		_108_Convert_Sorted_Array_to_Binary_Search_Tree test = new _108_Convert_Sorted_Array_to_Binary_Search_Tree();
		int[] nums = {3,5,8};
		test.sortedArrayToBST(nums);
	}
	
	public TreeNode sortedArrayToBST(int[] nums) {
		return sortedArrayToBST(nums,0,nums.length-1);
    }
	
	public TreeNode sortedArrayToBST(int[] nums, int i, int j){
		if(i > j) return null;
		if(i == j) return new TreeNode(nums[i]);
		int mid = ( i + j) >>> 1;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = sortedArrayToBST(nums,i,mid-1);
		root.right = sortedArrayToBST(nums,mid+1,j);
		return root;
	}
	
}
