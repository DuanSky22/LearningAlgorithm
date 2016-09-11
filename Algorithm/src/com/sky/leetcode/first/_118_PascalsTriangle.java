package com.sky.leetcode.first;

import java.util.ArrayList;
import java.util.List;

public class _118_PascalsTriangle {
	
	public static void main(String args[]){
		int numRows=5;
		generate(numRows);
	}
	
	/*
	 * here is the intelligent solution��
	 * we generate [1,4,4,1] from [1,3,1].
	 * first we add 1 to the head of [1,3,1], then we get
	 * [1,1,3,1], now we just replace a[j]=a[j]+a[j+1] j=2,...,k-1
	 * here we get[1,4,4,1]. how genius it is!
	 */
	public List<List<Integer>> generate0(int numRows)
	{
	    List<List<Integer>> allrows = new ArrayList<List<Integer>>();
	    ArrayList<Integer> row = new ArrayList<Integer>();
	    for(int i=0;i<numRows;i++)
	    {
	        row.add(0, 1);
	        for(int j=1;j<row.size()-1;j++)
	            row.set(j, row.get(j)+row.get(j+1));
	        allrows.add(new ArrayList<Integer>(row));
	    }
	    return allrows;

	}
	
	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(numRows>0){
            List<Integer> t1=new ArrayList<Integer>();
            t1.add(1);
            result.add(t1);
            if(numRows>=2){
                List<Integer> t2=new ArrayList<Integer>();
                t2.add(1);
                t2.add(1);
                result.add(t2);
            }
            if(numRows>=3){
                for(int i=3;i<=numRows;i++){
                    List<Integer> t=new ArrayList<Integer>();
                    t.add(1);
                    for(int k=1;k<=i-2;k++){
                        int number=result.get(i-2).get(k-1)+result.get(i-2).get(k);
                        t.add(number);
                    }
                    t.add(1);
                    result.add(t);
                }
            }
        }
        return result;
    }
}
