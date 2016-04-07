package com.sky.leetcode;

import java.util.HashMap;

public class _337_House_Robber_III {
	public int rob(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;
        int t1 = rob(root.left) + rob(root.right);
        int t2 = root.val +( root.left == null ? 0 : (rob(root.left.left)+rob(root.left.right)))
        		+ (root.right == null ? 0 : (rob(root.right.left) + rob(root.right.right)));
        return t1 > t2 ? t1 : t2;
    }
	
	public int rob_2(TreeNode root){
		return core_2(root,new HashMap<TreeNode,Integer>());
	}

	private int core_2(TreeNode root, HashMap<TreeNode, Integer> cache) {
		if(root == null) return 0;
		if(cache.containsKey(root)) return cache.get(root);
		if(root.left == null && root.right == null){
			cache.put(root, root.val);
			return root.val;
		}
		int t1 = core_2(root.left, cache) + core_2(root.right,cache);
		int t2 = root.val +( root.left == null ? 0 : (core_2(root.left.left,cache)+core_2(root.left.right,cache)))
        		+ (root.right == null ? 0 : (core_2(root.right.left,cache) + core_2(root.right.right,cache)));
		int res = t1 > t2 ? t1 : t2;
		cache.put(root, res);
		return res;
	}
	
	public int rob_3(TreeNode root){
		int[] res = core_3(root);
		return Math.max(res[0], res[1]);
	}
	
	//res[2] res[0]:不选当前节点时的最大值，res[1]：选当前节点时的最大值
	private int[] core_3(TreeNode curr){
		if(curr == null) return new int[]{0,0};
		if(curr.left == null && curr.right == null) return new int[]{0,curr.val};
		int[] left = core_3(curr.left);
		int[] right = core_3(curr.right);
		int[] res = {0,0};
		res[1] = curr.val + left[0] + right[0]; //选当前节点
		res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		return res;
	}
}
