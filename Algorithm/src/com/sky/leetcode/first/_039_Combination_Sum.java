package com.sky.leetcode.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author DuanSky
 * @date 2016年1月19日 下午8:11:04
 * @content 
 */

public class _039_Combination_Sum {
	
	public static void main(String args[]){
		_039_Combination_Sum test = new _039_Combination_Sum();
		int[] candidates = {5};
		int target =12;
		System.out.println(test.combinationSum(candidates, target));
	}
	
	/**
	 * @param result 存储最终的结果
	 * @param curr 当前遍历时的一个结果的中间状态
	 * @param candidates 
	 * @param target
	 * @param i 遍历到第几个元素
	 */
	public void solution(List<List<Integer>> result,List<Integer> curr,int[] candidates,int target,int i){
		if(target>0){
			curr.add(candidates[i]);
			solution(result,curr,candidates,target-candidates[i],i);
		}
		else if(target == 0)
			result.add(curr);
	}
	
	//下面的代码太长。
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> f[] = new ArrayList[target+1];
		List<List<Integer>> res = new ArrayList<>();
        if(candidates==null || candidates.length==0) return res;
        int i=0,z=0;
        while(i<candidates.length && candidates[i]>target ) i++;
        if(i>=candidates.length) return res;
        for(int j=candidates[i];j<=target;j++)//初始化
        	if(j%candidates[i]==0){
        		z=j/candidates[i];
        		List<Integer> temp = new ArrayList<>();
        		for(int t=0;t<z;t++) temp.add(candidates[i]);
        		if(f[j]==null) f[j]=new ArrayList<>();
        		f[j].add(temp);
        	}
        for(i=i+1;i<candidates.length && candidates[i]<=target;i++){
        	for(int j=target;j>=candidates[i];j--){
        		for(int k=1;k*candidates[i]<=j;k++){
        			//MISTAKE 
        			if(f[j-k*candidates[i]]==null || f[j-k*candidates[i]].size()==0) 
        				continue;
        			
        			List<Integer> added = new ArrayList<>();
        			for(int t=0;t<k;t++) added.add(candidates[i]);
        			
        			int size =f[j-k*candidates[i]].size();
        			for(int l=0;l<size;l++){
        				List<Integer> temp = new ArrayList<>(f[j-k*candidates[i]].get(l));
        				temp.addAll(added);
        				if(f[j]==null) f[j]=new ArrayList<>();
        				f[j].add(temp);
        			}
        		}
        		if(j%candidates[i]==0){
            		z=j/candidates[i];
            		List<Integer> temp = new ArrayList<>();
            		for(int t=0;t<z;t++) temp.add(candidates[i]);
            		if(f[j]==null) f[j]=new ArrayList<>();
            		f[j].add(temp);
            	}
        	}
        }
        //MISTAKE 返回的值如果为null?
        return f[target]==null ? res : f[target];
    }

}
