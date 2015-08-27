package com.njz.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class _236_LowestCommonAncestorofaBinarySearchTree {
	
	public static TreeNode getLowest(TreeNode root, TreeNode p, TreeNode q){
		List<TreeNode> list1 = new ArrayList<TreeNode>();
		List<TreeNode> list2 = new ArrayList<TreeNode>();

		getTreeNodePath(root, p, list1);
		getTreeNodePath(root, q, list2);
		
		TreeNode rs = null;
		int i = 0, j = 0;
		
		while(i<list1.size() && j<list2.size()){
			if(list1.get(i) == list2.get(j)){
				rs = list1.get(i);
				i++;
				j++;
			}else
				break;
		}
				
		return rs;
	}
	
	public static void getTreeNodePath(TreeNode start,TreeNode target, List<TreeNode> nodes){
		nodes.add(start);
		if(start == target) return;
			
		if(target.val > start.val )
			getTreeNodePath(start.right, target, nodes);
		else
			getTreeNodePath(start.left, target, nodes);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] nodes = {"6","2","8","3"};
//		TreeNode root = generate(nodes);
		
		//��ʼ����
		TreeNode root = new TreeNode(6);
		TreeNode l1 =  new TreeNode(2);
		TreeNode r1 =  new TreeNode(8);
		root.left = l1;
		root.right = r1;
		
		TreeNode l2 =  new TreeNode(0);
		TreeNode r2 =  new TreeNode(4);
		l1.left = l2;
		l1.right = r2;
		
		TreeNode l3 =  new TreeNode(3);
		TreeNode r3 =  new TreeNode(5);
		r2.left = l3;
		r2.right = r3;
		
		TreeNode l22 =  new TreeNode(7);
		TreeNode r22 =  new TreeNode(9);
		r1.left = l22;
		r2.right = r22;
		
		TreeNode rs = getLowest(root, l1,l2);
		System.out.println("test : " + rs.val);
	}
	
	
	private static TreeNode generate(String[] nodes) {
		if(nodes == null || nodes.length == 0)
			return null;
		
		TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		int i = 1;
		
		while(!q.isEmpty() && i<nodes.length){
			TreeNode node = q.poll();
			if(!nodes[i].equals("#")){
				TreeNode node_left = new TreeNode(Integer.valueOf(nodes[i]));
				q.offer(node_left);
				node.left = node_left;
				i++;
			}else{
				i++;
			}
			
			if(i < nodes.length && !nodes[i].equals("#")){
				TreeNode node_right = new TreeNode(Integer.valueOf(nodes[i]));
				q.offer(node_right);
				node.right = node_right;
				i++;
			}else{
				i++;
			}
		}
		
		return root;
	}

}
