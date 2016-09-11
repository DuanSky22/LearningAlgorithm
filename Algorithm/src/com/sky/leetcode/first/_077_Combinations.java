/**
* @author DuanSky
* @date 2015��11��3�� ����9:43:15
* @content 
*/
package com.sky.leetcode.first;

import java.util.ArrayList;
import java.util.List;

public class _077_Combinations {
	
	public static void main(String args[]){
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		List<Integer> list=new ArrayList<Integer>();
		combine0(result,list,1,2,4);
	}
	
	public static void combine0(List<List<Integer>> result,List<Integer> list,int i,int k,int n){
		if(i>n+1 || (list!=null && list.size()>k)) return; 
		if(list.size()==k){
			result.add(new ArrayList<Integer>(list));
			return;
		}
		list.add(i);
		combine0(result,list,i+1,k,n);
		list.remove(list.size()-1);
		combine0(result,list,i+1,k,n);
	}
	
	/*
	 * wrong solution! pay attention to it!
	 */
	 public List<List<Integer>> combine(int n, int k) {
	        List<List<Integer>> result=new ArrayList<List<Integer>>();
	        for(int i=1;i<=n-k+1;i++){
	            List<Integer> list=new ArrayList<Integer>();
	            for(int j=i;j<i+k-1;j++){
	                list.add(j);
	            }
	            list.add(i+k-1);
	            result.add(list);
	        }
	        return result;
	    }
	
}
