package com.sky.leetcode;

import java.util.Arrays;

/**
 * @author DuanSky
 * @date 2016年1月7日 下午2:20:15
 * @content 
 */

public class _106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return generate(inorder,postorder,inorder.length-1);
    }
	
	public TreeNode generate(int[] inorder,int[] postorder,int pos){
		if(inorder==null || inorder.length==0 || pos<0) return null;
		TreeNode root = new TreeNode(postorder[pos]);
		int pivot = find(inorder,postorder[pos]);
		int[] left = Arrays.copyOfRange(inorder, 0,pivot);
		int[] right = Arrays.copyOfRange(inorder, pivot+1, inorder.length);
		root.right = generate(right,postorder,pos-1);
		root.left = generate(left,postorder,pos-(inorder.length-pivot-1)-1);
		return root;
	}
	
	public int find(int[] array,int key){
		for(int i=0;i<array.length;i++)
			if(array[i]==key) return i;
		return -1;
	}

}
