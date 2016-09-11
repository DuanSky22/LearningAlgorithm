/**
* @author DuanSky
* @date 2015��10��19�� ����7:08:47
* @content 
*/
package com.sky.leetcode.first;

import java.util.ArrayList;
import java.util.List;

public class _113_PathSumII_NotFinished {
	
	public static void main(String args[]){
		
	}
	
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(root==null) return result;
        List<Integer> current=new ArrayList<Integer>();
        currentSum(result,current,root,sum);
        return result;
    } 
	//The algorithm below may cost much memory!
	public static void currentSum(List<List<Integer>> result,List<Integer> current,TreeNode subroot,int sum){
		if(subroot.left==null && subroot.right==null){
			if(sum==subroot.val){
				current.add(subroot.val);
				result.add(current);
			}
		}
		if(subroot.left!=null){
			List<Integer> temp=new ArrayList<Integer>();
			temp.addAll(current);
			temp.add(subroot.val);
			currentSum(result,temp,subroot.left,sum-subroot.val);
		}
		if(subroot.right!=null){
			List<Integer> temp=new ArrayList<Integer>();
			temp.addAll(current);
			temp.add(subroot.val);
			currentSum(result,temp,subroot.right,sum-subroot.val);
		}
	}

}
