/**
* @author DuanSky
* @date 2015年10月24日 下午12:46:15
* @content 
*/
package com.sky.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _107_BinaryTreeLevelOrderTraversalII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result=new LinkedList<List<Integer>>();
        if(root==null)
        	return result;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
        	int size=queue.size();
        	List<Integer> list=new ArrayList<Integer>();
        	for(int i=0;i<size;i++){
        		TreeNode node=queue.poll();
        		list.add(node.val);
        		if(node.left!=null) queue.add(node.left);
        		if(node.right!=null) queue.add(node.right);
        	}
        	result.add(0, list);
        }
        
        return result;
    }
}
