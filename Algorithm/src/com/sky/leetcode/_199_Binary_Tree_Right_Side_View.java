package com.sky.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _199_Binary_Tree_Right_Side_View {
	
	public static void main(String args[]){
		_199_Binary_Tree_Right_Side_View test = new _199_Binary_Tree_Right_Side_View();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2); root.right = new TreeNode(3);
		System.out.println(test.rightSideView0(root));
	}
	
	public List<Integer> rightSideView0(TreeNode root) {
		int height = height(root);
		Integer res[] = new Integer[height];
		res[0] = root.val;
		rightSideView0(root,res,0);
		return Arrays.asList(res);
	}
	//=================================================================
	
	public List<Integer> rightSideView1(TreeNode root){
		List<Integer> res = new ArrayList<>();
		rightSideView1(root,res,0);
		return res;
	}
	
	private void rightSideView1(TreeNode curr,List<Integer> res, int depth){
		if(curr == null) return;
		if(depth == res.size()) res.add(curr.val);
		rightSideView1(curr.right,res,depth+1);
		rightSideView1(curr.left,res,depth+1);
	}
	
	
	//=================================================================
	private int height(TreeNode curr){
		if(curr == null) return 0;
		return Math.max(height(curr.left), height(curr.right))+1;
	}
	
	private void rightSideView0(TreeNode curr, Integer[] res,int i) {
		if(curr == null) return ;
		if(curr.left != null){
			res[i+1] = curr.left.val;
			rightSideView0(curr.left,res,i+1);
		}
		if(curr.right != null){
			res[i+1] = curr.right.val;
			rightSideView0(curr.right,res,i+1);
		}
	}
	//=================================================================
	//采用层次遍历的方法
	 public List<Integer> rightSideView(TreeNode root) {
	   List<Integer> res = new ArrayList<Integer>(); 
	   if(root == null) return res;
	   Queue<TreeNode> queue = new LinkedList<TreeNode>();
	   queue.add(root);
	   while(!queue.isEmpty()){
		   int size = queue.size();
		   for(int i = 0; i < size; i++){
			   TreeNode curr = queue.poll();
			   if(i == size - 1) res.add(curr.val);
			   if(curr.left != null) queue.add(curr.left);
			   if(curr.right != null) queue.add(curr.right);
		   }
	   }
	   return res;
	 }
}
