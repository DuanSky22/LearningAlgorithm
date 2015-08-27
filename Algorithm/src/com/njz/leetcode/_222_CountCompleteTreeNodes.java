package com.njz.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class _222_CountCompleteTreeNodes {
	
	public static List<List<Integer>> levelOrderBottom(TreeNode root){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		
		if(root == null){
			return result;
		}
//		int startNode = Integer.MAX_VALUE;//不可以用数值，容易出现重复
		TreeNode startNode = null;
		List<Integer> levelList = new ArrayList<Integer>();
		while(!q.isEmpty()){
			TreeNode tempNode = q.poll();
			if(tempNode == startNode){
				result.add(levelList);
				levelList = new ArrayList<Integer>();
				startNode = null;
			}
			
			if(tempNode.left != null){
				q.offer(tempNode.left);
				if(startNode == null)
					startNode = tempNode.left;
			}
			
			if(tempNode.right != null){
				q.offer(tempNode.right);
				if(startNode == null)
					startNode = tempNode.right;
			}
			
			levelList.add(tempNode.val);
		}
		result.add(levelList);
		Collections.reverse(result); 
		return result;
	}
	
	
	public static TreeNode invertTree(TreeNode root) {
		if(root == null)
			return null;
		TreeNode tmp = root.left;
		root.left = invertTree(root.right);
		root.right = invertTree(tmp);
	    return root;
	}
	
	//分治
	public static int countNodes1(TreeNode root) {
		if(root == null)
			return 0;
		int left = countLevel(root.left);
		int right = countLevel(root.right);
		
		int leftNum = (2<<left-1)-1;
		int rightNum = (2<<right-1)-1;
		
		if(left == 0)
			leftNum = 0;
		if(right == 0)
			rightNum = 0;
		
		if(left == right){//leftTree is full
			return countNodes1(root.right)+leftNum+1;
		}else{//rightTree is full
			return countNodes1(root.left)+rightNum+1;
		}
	}
	
	public static int countLevel(TreeNode node){
		if(node == null)
			return 0;
		return countLevel(node.left)+1;
	}
	
	//bfs---count---timeOut
	public static int countNodes(TreeNode root) {
		if(root == null)
			return 0;
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while(!q.isEmpty()){
			TreeNode node = q.poll();
			nodes.add(node);
			if(node.left != null)
				q.offer(node.left);
			if(node.right != null)
				q.offer(node.right);
		}
        return nodes.size();
    }
	
	//Recursive solution is trivial, could you do it iteratively
	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> preOrder = new ArrayList<Integer>();
		if(root == null)
			return preOrder;

		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		while( !s.isEmpty() ){
			TreeNode node = s.pop();
			preOrder.add(node.val);
			if(node.right != null)
				s.push(node.right);
			if(node.left != null)
				s.push(node.left);
		}
		return preOrder;
	}
	
	public static void main(String[] args){
//		String[] a = {"1","#","2","3"};
		String[] a = {"3","1","2"};
//		String[] a = {"3","9","20","#","#","15","7"};
//		String[] a = {"3","9","20","12","3","15","7"};
//		String[] a = {"3","9","20","12","3","#","#"};
//		String[] a = {"1","2","3","#","#","4","#","#","5"};
		
		TreeNode root = new TreeNode(Integer.valueOf(a[0]));
		
		//construct_2 binaryTree
//		TreeNode emptyNode = new TreeNode(0);
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		
		int i = 1;
		while(!q.isEmpty() && i<a.length){
			TreeNode node = q.poll();
//			if(node.val != 0){
				if(!a[i].equals("#")){
					TreeNode node1 = new TreeNode(Integer.valueOf(a[i]));
					q.offer(node1);
					node.left = node1;
					i++;
				}else{
//					q.offer(emptyNode);
					i++;
				}
				
				if(i<a.length && !a[i].equals("#")){
					TreeNode node1 = new TreeNode(Integer.valueOf(a[i]));
					q.offer(node1);
					node.right = node1;
					i++;
				}else{
//					q.offer(emptyNode);
					i++;
				}
//			}
		}//end while
		
//		List<List<Integer>> result = levelOrderBottom(root);
//		TreeNode rs = invertTree(root);
//		int count  = countNodes(root);
		int count  = countNodes1(root);
		List<Integer> rs = preorderTraversal(root);
		System.out.println(rs);
		System.out.println("done!");
	}
}//end class
