package com.sky.leetcode;

public class _327_Count_of_Range_Sum_2Round {
	
	public static void main(String args[]){
		int[] nums = {-2, 5, -1};
		int lower = -2, upper = 2; 
		_327_Count_of_Range_Sum_2Round test = new _327_Count_of_Range_Sum_2Round();
		System.out.println(test.countRangeSum(nums, lower, upper));
	}
	
	public int countRangeSum(int[] nums, int lower, int upper) {
		SegmentTree tree = new SegmentTree(nums);
		int count = 0;
		for(int i = 0; i < nums.length; i++){
			for(int j = i; j < nums.length; j++){
				int subSum = tree.getSumRange(i, j);
				if(subSum >= lower && subSum <= upper)
					count++;
			}
		}
		return count;
    }

	public class SegmentTree{
		
		private STNode root;
		private int[] nums;
		
		public SegmentTree(int[] nums){
			this.nums = nums;
			root = buildTree(0,nums.length-1);
		}
		
		private STNode buildTree(int start,int end) {
			STNode curr = new STNode(start,end);
			if(start == end) curr.value = nums[start];
			else{
				curr.left = buildTree(start,(start+end)/2);
				curr.right = buildTree((start+end)/2+1,end);
				curr.value = curr.left.value + curr.right.value;
			}
			return curr;
		}
		
		public void updateTree(int i, int value){
			updateTree(i,root,value);
		}
		private void updateTree(int i,STNode curr,int value){
			if(curr.start == curr.end)
				curr.value = value;
			int start = curr.start, end = curr.end, mid = (start + end)/2;
			if(i <= mid) updateTree(i,curr.left,value);
			else updateTree(i,curr.right,value);
			curr.value = curr.left.value + curr.right.value;
		}

		public int getSumRange(int start,int end){
			return getSumRange(root,start,end);
		}
		public int getSumRange(STNode curr,int start,int end){
			if(curr.start == start && curr.end == end)
				return curr.value;
			int currStart = curr.start, currEnd = curr.end, currMid = (currStart + currEnd)/2;
			if(start > currMid) return getSumRange(curr.right,start,end);
			else if( end <= currMid) return getSumRange(curr.left,start,end);
			else
				return getSumRange(curr.left,start,currMid) + getSumRange(curr.right,currMid+1,end);
		}


		class STNode{
			int start, end;
			STNode left,right;
			int value;
			STNode(int start,int end){
				this.start = start;
				this.end = end;
			}
		}
	}
}
