/**
* @author DuanSky
* @date 2015��9��29�� ����9:57:33
* @content 
* [-1,2147483647]
1
2147483647
*/
package com.sky.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class _220_ContainsDuplicateIII_NotFinished {
	
	public static void main(String args[]){
		_220_ContainsDuplicateIII_NotFinished test = new _220_ContainsDuplicateIII_NotFinished();
		int[] nums = {-1,-1};
		int k = 1, t = 0;
		System.out.println(test.containsNearbyAlmostDuplicate(nums, k, t));
	}
	

	public boolean containsNearbyAlmostDuplicate(int[] nums,int k,int t){
		if(nums.length == 0 || k < 1 || t < 0) return false; 
		SortedSet<Long> tree = new TreeSet<>();
		for(int i=0;i<nums.length;i++){
			if(tree.size()==k+1) tree.remove((long)nums[i-k-1]);
			SortedSet<Long> sub = tree.subSet((long)nums[i]-t, (long)nums[i]+t+1);
			if(!sub.isEmpty()) return true;
			tree.add((long) nums[i]);
 		}
		return false;
	}
	
	public boolean containsNearbyAlmostDuplicate_bucket(int[] nums,int k,int t){
		//MISTAKE 1.注意需要考虑t<0的情况
		if(nums.length == 0 || k < 1 || t < 0) return false; 
		Map<Long,Long> bucket = new HashMap<>();
		for(int i=0;i<nums.length;i++){
			//MISTAKE 2.注意，非常需要注意，这里需要int->long。
			long temp = (long)nums[i] - Integer.MIN_VALUE;
			long curr = temp/((long)t+1);
			if(bucket.containsKey(curr) || 
					(bucket.containsKey(curr-1) && nums[i]-bucket.get(curr-1)<=t) ||
					(bucket.containsKey(curr+1) && bucket.get(curr+1)-nums[i]<=t)) return true;
			if(bucket.size()==k) bucket.remove((((long)nums[i-k] - Integer.MIN_VALUE)) / (t+1));
			bucket.put(curr,(long)nums[i]);
		}
		return false;
	}
	
	//当数组中有重复元素时，算法不正确。
	public boolean containsNearbyAlmostDuplicate_wrong_solution(int[] nums,int k, int t){
		if(nums.length>0){
			Map<Integer,Integer> map = new HashMap<>();
			for(int i=0;i<nums.length;i++)
				map.put(nums[i], i);
			Arrays.sort(nums);
			for(int i=0;i<nums.length-1;i++){
				for(int j=i+1;j-i<=k &&nums[j]-nums[i]<=t;j++){
					if(Math.abs(map.get(nums[j])-map.get(nums[i]))<=k) return true;
				}
			}
		}
		return false;
	}
	
	//当t值比较大时，时间复杂度和空间复杂度都很高。
	public boolean containsNearbyAlmostDuplicate_(int[] nums, int k, int t) {
        if(nums.length>0){
			Map<Integer,Integer> map=new HashMap<Integer,Integer>();
			for(int i=0;i<nums.length;i++){
				if(map.containsKey(nums[i]))
					if(i-map.get(nums[i])<=k)
						return true;
					else
						for(int z=-t;z<=t;z++)
							map.put(nums[i]+z, i);
				else
					for(int z=-t;z<=t;z++)
						map.put(nums[i]+z, i);
			}
		}
		return false;
    }
}
