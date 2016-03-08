package com.sky.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author DuanSky
 * @date 2016年1月11日 下午2:28:02
 * @content 
 */

public class _120_Triangle {
	public static void main(String args[]){
		List<List<Integer>> triangle = new ArrayList<>();
		List<Integer> l1= new ArrayList<>(Arrays.asList(-1));triangle.add(l1);
		List<Integer> l2= new ArrayList<>(Arrays.asList(-2,-3));triangle.add(l2);
//		List<Integer> l3= new ArrayList<>(Arrays.asList(6,5,7));triangle.add(l3);
//		List<Integer> l4= new ArrayList<>(Arrays.asList(4,1,8,3));triangle.add(l4);

		System.out.println(minimumTotal(triangle));
	}
	public static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null || triangle.size()==0) return 0;
        int t = triangle.size(), size = t*(t+1)/2, minSum = Integer.MAX_VALUE;
        int count[]=new int[size]; count[0]=triangle.get(0).get(0);
        if(t == 1) return count[0];
        for(int i=1;i<t;i++){//for i layer.
        	//MISTAKE 注意这里的j的取值范围。
        	for(int j=0;j<=i;j++){ // for j number.
        		count[i*(i+1)/2+j] = Math.min(j-1>=0 ? 
        				count[i*(i-1)/2+j-1]+triangle.get(i).get(j) : Integer.MAX_VALUE, 
        				j<i ? count[i*(i-1)/2+j]+triangle.get(i).get(j) : Integer.MAX_VALUE);
        		if(i==t-1)
        			minSum = Math.min(minSum, count[i*(i+1)/2+j]);
        	}
        }
        return minSum;
    }
}
