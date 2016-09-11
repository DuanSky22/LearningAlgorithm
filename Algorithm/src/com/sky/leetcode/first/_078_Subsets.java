/**
* @author DuanSky
* @date 2015��10��11�� ����3:25:54
* @content 
*/
package com.sky.leetcode.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _078_Subsets {
	
	public static void main(String args[]){
		int[] nums={1,2,3,4};
		System.out.println(subsets(nums));
		System.out.println(_subsets(nums));
	}
	
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		result.add(new ArrayList<Integer>());
		for(int i=1;i<Math.pow(2, nums.length);i++){
			List<Integer> list=new ArrayList<Integer>();
			int t=i;int k=0;
			while(t!=0){
				if((t&1)==1)
					list.add(nums[k]);
				Collections.sort(list);
				k++;
				t>>=1;
			}
			result.add(list);
		}	
		
        return result;
    }
	
	public static List<List<Integer>> _subsets(int[] nums){
		Arrays.sort(nums);
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		List<Integer> empty=new ArrayList<Integer>();
		result.add(empty);
		for(int num : nums){
			int length=result.size();
			for(int i=0;i<length;i++){
				List<Integer> copy=new ArrayList<Integer>(result.get(i));
				copy.add(num);
				result.add(copy);
			}
		}
		return result;
	}

}
