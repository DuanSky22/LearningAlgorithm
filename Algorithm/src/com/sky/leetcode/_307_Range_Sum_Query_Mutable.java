package com.sky.leetcode;

public class _307_Range_Sum_Query_Mutable  {
	
	public static void main(String args[]){
		int[] nums = {1,3,5};
		NumArray test = new NumArray(nums);
		System.out.println(test.sumRange(0, 2));
		test.update(1, 2);
		System.out.println(test.sumRange(0, 2));
	}
	
	static class NumArray{
		private int[] nums;
		private SegmentTreeNode root;
		public NumArray(int[] nums){
		    if(nums == null || nums.length == 0) return;
			this.nums = nums;
			root = this.build(0, nums.length-1);
		}
		class SegmentTreeNode{
			public SegmentTreeNode(int start, int end) {
				this.start = start;
				this.end = end;
			}
			int start, end; //inclusive
			SegmentTreeNode left , right;
			int sum;
		}
		
		public SegmentTreeNode build(int start,int end){
			SegmentTreeNode node = new SegmentTreeNode(start,end);
			if(start == end) node.sum = nums[start];
			else{
				node.left = build(start,(start+end)/2);
				node.right = build((start+end)/2+1,end);
				node.sum = node.left.sum + node.right.sum;
			}
			return node;
		}
		
		public int sumRange(int i, int j){
			return queryRange(root,i,j);
		}
		//自上而下的分解
		public int queryRange(SegmentTreeNode curr, int start,int end){
			if(start == curr.start && end == curr.end)
				return curr.sum;
			int mid = curr.start + (curr.end - curr.start) / 2;
			if(start > mid)
				return queryRange(curr.right,start,end);
			else if(end <= mid)
				return queryRange(curr.left,start,end);
			else
				return queryRange(curr.left,start,mid) + queryRange(curr.right,mid+1,end);
		}
		
		public void update(int i,int val){
			update(root,i,val);
		}
		//自底往上的更新
		public void update(SegmentTreeNode curr, int i, int val){
			if(curr.start == curr.end){
				curr.sum = val;
				return;
			}
			int mid = curr.start + (curr.end - curr.start) / 2;
			if(i <= mid) update(curr.left,i,val);
			else update(curr.right,i,val);
			curr.sum = curr.left.sum + curr.right.sum;
		}
	}
	
	public class NumArray_ {
		private int[] nums;
		private int[] sums;
	    public NumArray_(int[] nums) {
	        if(nums == null || nums.length == 0) return;
	        this.nums = nums;
	        sums = new int[nums.length];
	        sums[0] = nums[0];
	        for(int i = 1; i < nums.length; i++)
	        	sums[i] = sums[i-1] + nums[i];
	    }

	    void update(int i, int val) {
	        for(int k = i; k < sums.length; k++)
	        	sums[k] = sums[k] - nums[i] + val;
	    }

	    public int sumRange(int i, int j) {
	        if(i == 0) return sums[j];
	        return sums[j] - sums[i-1];
	    }
	}
}
