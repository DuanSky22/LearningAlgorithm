/**
* @author DuanSky
* @date 2015年10月11日 下午3:25:54
* @content 
*/
package com.sky.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _078_Subsets {
	
	public static void main(String args[]){
		int[] nums={};
		subsets(nums);
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

}
