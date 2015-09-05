package com.sky.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * �������ѵ�������ζ�����������Ĵ���
 * ���£�[""],["",""],["a"]
 * ѧϰArrays.asList();
 */
public class _049_GroupAnagrams {
	
	public static void main(String args[]){
		String[] strs={"and","dna"};
//		List<String> list=Arrays.asList(new String());
//		list.add(new String());
		groupAnagrams(strs);
	}
	public static List<List<String>> groupAnagrams(String[] strs){
		List<List<String>> list=new ArrayList<List<String>>();
		Map<String,List<String>> map=new HashMap<String,List<String>>();
		if(strs.length==0)
			return list;
		int n=strs.length;
		for(int i=0;i<n;i++){
			String temp=strs[i];
			char[] tempChar=temp.toCharArray();
			Arrays.sort(tempChar);
			temp=new String(tempChar);
			if(temp.isEmpty()){
				if(map.containsKey("_empty_"))
					map.get("_empty_").add(new String());
				else{
					List<String> tempList=new ArrayList<String>();
					tempList.add(new String());
					map.put("_empty_", tempList);
				}
			}
			else{
				if(map.containsKey(temp))
					map.get(temp).add(strs[i]);
				else{
					List<String> tempList=new ArrayList<String>();
					tempList.add(strs[i]);
					map.put(temp, tempList);
				}
			}
			
		}
		for(Entry<String,List<String>> entry : map.entrySet()){
			List<String> tempList=entry.getValue();
			Collections.sort(tempList);
			list.add(tempList);
		}
		return list;
	}
/*
	public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list=new ArrayList<List<String>>();
        //������������ֵ��ӳ��
        Map<Integer[],Integer> map=new HashMap<Integer[],Integer>();
        int type=0;
        int n=strs.length;
        //�����������ӳ��
        int[] result=new int[n];
        
        for(int i=0;i<n;i++){
            String temp=strs[i];
            int length=temp.length();
            Integer[] tempArray=new Integer[26];
            //ע������Ҫ�Զ����ʼ����
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
        //��ʼ������
        for(int i=0;i<type;i++){
        	List temp=new ArrayList<String>();
        	list.add(temp);
        }
        //�������
        for(int i=0;i<n;i++){
            if(strs[i]!=null && !strs[i].isEmpty())
        	    list.get(result[i]-1).add(strs[i]);
        }
        //���ֵ�˳������
        for(int i=0;i<type;i++){
        	java.util.Collections.sort(list.get(i));
        }
        return list;
    }
    */
}
