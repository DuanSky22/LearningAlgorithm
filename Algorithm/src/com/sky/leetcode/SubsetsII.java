/**
* @author DuanSky
* @date 2015年10月11日 下午3:56:15
* @content 
*/
package com.sky.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SubsetsII {
	
	
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        //rebuild input number.
        List<List<Integer>> input=new ArrayList<List<Integer>>();
        for(int num : nums){
        	boolean find=false;
        	for(List<Integer> list : input){
        		if(list.get(0)==num){
        			list.add(num);
        			find=true;
        		}
        	}
        	if(find==false){
        		List<Integer> temp=new ArrayList<Integer>();
        		temp.add(num);
        	}
        }
        //
        int count=input.size();
        for(int i=1;i<Math.pow(2, count);i++){
        	int k=0;int t=i;
        	
        	while(t!=0){
        		if((t&1)==1){
        			List<Integer> list=new ArrayList<Integer>();
        			list.add(nums[k]);
        		}
        	}
        }
        return result;
    }
}
