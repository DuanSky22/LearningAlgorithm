/**
* @author DuanSky
* @date 2015��10��24�� ����12:22:31
* @content 
*/
package com.sky.leetcode.first;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _102_BinaryTreeLevelOrderTraversal_6 {
	
	//use queue to realize the breadth-first search. 
	 public List<List<Integer>> levelOrder(TreeNode root) {
		 List<List<Integer>> result=new ArrayList<List<Integer>>();
		 if(root==null)
			 return result;
		 Queue<TreeNode> queue=new LinkedList<TreeNode>();
		 queue.add(root);
		 while(!queue.isEmpty()){
			 List<Integer> list=new ArrayList<Integer>();
			 int size=queue.size();
			 for(int i=0;i<size;i++){
				 TreeNode temp=queue.poll();
				 list.add(temp.val);
				 if(temp.left!=null)
					 queue.add(temp.left);
				 if(temp.right!=null)
					 queue.add(temp.right);
			 }
			 result.add(list);
		 }
		 return result;
	 }
}
