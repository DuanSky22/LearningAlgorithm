package com.sky.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 这道题的难点在于如何对于特殊情况的处理：
 * 如下：[""],["",""],["a"]
 */
public class _004_GroupAnagrams {
	
	public static void main(String args[]){
		String[] strs={"a"};
		groupAnagrams(strs);
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list=new ArrayList<List<String>>();
        //保存类型与数值的映射
        Map<Integer[],Integer> map=new HashMap<Integer[],Integer>();
        int type=0;
        int n=strs.length;
        //保存分类结果的映射
        int[] result=new int[n];
        
        for(int i=0;i<n;i++){
            String temp=strs[i];
            int length=temp.length();
            Integer[] tempArray=new Integer[26];
            //注意这里要对对象初始化。
            for(int t=0;t<26;t++)
                tempArray[t]=0;
            for(int j=0;j<length;j++){
                tempArray[temp.charAt(j)-'a']++;
            }
            if(map.containsKey(tempArray)){
                result[i]=map.get(tempArray);
            }
            else{
                type++;
                map.put(tempArray,type);
                result[i]=type;
            }
        }
        //初始化数组
        for(int i=0;i<type;i++){
        	List temp=new ArrayList<String>();
        	list.add(temp);
        }
        //填充数组
        for(int i=0;i<n;i++){
            if(strs[i]!=null && !strs[i].isEmpty())
        	    list.get(result[i]-1).add(strs[i]);
        }
        //按字典顺序排序
        for(int i=0;i<type;i++){
        	java.util.Collections.sort(list.get(i));
        }
        return list;
    }
}
