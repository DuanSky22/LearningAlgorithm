package com.sky.leetcode.first;

import java.util.LinkedList;
import java.util.Queue;

public class _297_Serialize_and_Deserialize_Binary_Tree {
	
	
	public static void main(String args[]){
		Codec test = new _297_Serialize_and_Deserialize_Binary_Tree().new Codec();
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1); root.right = new TreeNode(3);
		root.left.right = new TreeNode(2);  root.right.left = new TreeNode(4);
		System.out.println();
		test.deserialize(test.serialize(root));
	}
	
	public class Codec {

	    // Encodes a tree to a single string.
	    public String serialize(TreeNode root) {
	        StringBuilder res = new StringBuilder();
	        if(root == null) return "";
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        queue.offer(root); res.append(root.val+";");
	        while(!queue.isEmpty()){//一层一层的写入元素
	        	int size = queue.size();
	        	for(int i = 0; i < size; i++){
	        		TreeNode temp = queue.poll();
	        		if(temp.left != null) queue.add(temp.left);
	        		res.append( temp.left != null ? temp.left.val : "#");
	        		res.append(":");
	        		if(temp.right != null) queue.add(temp.right);
	        		res.append(temp.right != null ? temp.right.val : "#");
	        		if(i != size - 1) res.append(",");
	        	}
	        	res.append(";");
	        }
	        return res.toString();
	    }

	    // Decodes your encoded data to tree.
	    public TreeNode deserialize(String data) {
	        if(data == null || data.length() == 0) return null;
	        String rootS = data.substring(0,data.indexOf(";"));
	        TreeNode root = new TreeNode(Integer.parseInt(rootS));
	        data = data.substring(data.indexOf(";") + 1);
	        String[] layers = data.split(";");
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        queue.add(root);
	        for(String layer : layers){ //每一个layer对应一层
	        	String pairs[] = layer.split(","); //每个pair对应一个元素的左右两个分支
	        	int size = queue.size();
	        	for(int i = 0; i < size; i++){
	        		TreeNode curr = queue.poll();
	        		String node[] = pairs[i].split(":"); //针对每个节点
	        		if(!node[0].equals("#")){
	        			curr.left = new TreeNode(Integer.parseInt(node[0]));
	        			queue.add(curr.left);
	        		}
	        		if(!node[1].equals("#")){
	        			curr.right = new TreeNode(Integer.parseInt(node[1]));
	        			queue.add(curr.right);
	        		}
	        	}
	        }
	        return root;
	    }
	}
}
