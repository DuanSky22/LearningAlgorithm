package com.sky.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DuanSky
 * @date 2015年12月28日 下午5:20:34
 * @content 
 */

public class _095_Unique_Binary_Search_Trees_II {

	public static void main(String args[]){
		System.out.println(generateTrees(3));
	}
	
	public static List<TreeNode> generateTrees(int n) {
		if(n==0) return null;
        return generateTrees(1,n);
    }
	
	public static List<TreeNode> generateTrees(int start,int end) {
        ArrayList<TreeNode> lists=new ArrayList<TreeNode>();
        if(start>end){
        	lists.add(null);//MISTAKE 注意当为空时，也是一种情况！
        	return lists;
        }
        if(start==end){
        	lists.add(new TreeNode(start));
        	return lists;
        }
        for(int k=start;k<=end;k++){
        	List<TreeNode> left=generateTrees(start,k-1);
        	List<TreeNode> right=generateTrees(k+1,end);
        	for(TreeNode l : left){
        		for(TreeNode r : right){
                	TreeNode node=new TreeNode(k); //MISTAKE 注意要在里面申请一个空间，而不是在外面
        			node.left=l; node.right=r;
        			lists.add(node);
        		}
        	}
        }
    	return lists;
    }
	
	
}
