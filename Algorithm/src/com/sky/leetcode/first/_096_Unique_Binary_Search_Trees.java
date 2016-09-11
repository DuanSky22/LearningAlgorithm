package com.sky.leetcode.first;
/**
 * @author DuanSky
 * @date 2015年12月28日 下午4:58:09
 * @content 
 */

public class _096_Unique_Binary_Search_Trees {
	
	public static void main(String args[]){
		System.out.println(_numTrees(19));
		System.out.println(numTrees(19));
	}
	
	 public static int numTrees(int n) {
	     if(n==0 || n==1) return 1;
    	 int sum=0;
    	 for(int k=1;k<=n;k++)
    		 sum+=numTrees(k-1)*numTrees(n-k);
    	 return sum;
	 }
	 
	 public static int _numTrees(int n){
		 if(n<2) return 1;
		 int[] f=new int[n+1];
		 f[0]=1;f[1]=1;
		 for(int i=2;i<=n;i++)
			 for(int k=1;k<=i;k++)
				 f[i]+=f[k-1]*f[i-k];
		 return f[n];
	 }
	 
}
