/**
* @author DuanSky
* @date 2015年11月18日 下午10:26:23
* @content 
*/
package com.sky.leetcode;

public class FindK {
	
	public static void main(String args[]){
		int[] m={1,2,3};
		int[] n={2,3,6,7,8};
		System.out.println(findMedium(m,n));
	}
	
	public static int findMedium(int[] m,int[] n){
		int result=0;
		result=_findMedium(m,0,m.length-1,n,0,n.length-1,6);
		return result;
	}
	
	public static int _findMedium(int[] m,int m_start,int m_end,int[] n,int n_start,int n_end,int k){
		if(k==1)
				return Math.min(m[m_start],n[n_start]);
		int m_medium=m_start+k/2-1; //  k/2 position
		int n_medium=n_start+k/2-1;
		if(m_medium>=m_end){
			if(m[m_end]<=n[n_medium])
				return n[n_start+k-(m_end-m_start+1)-1];
			else
				return _findMedium(m,m_start,m_end,n,n_medium+1,n_end,k-k/2);
		}
		else if(n_medium>=n_end){
			if(n[n_end]<=m[m_medium])
				return n[n_start+k-(m_end-m_start+1)-1];
			else
				return _findMedium(m,m_medium+1,m_end,n,n_start,n_end,k-k/2);
		}
		else{
			if(m[m_medium]<n[n_medium])
				return _findMedium(m,m_medium+1,m_end,n,n_start,n_end,k-k/2);
			else if(m[m_medium]>n[n_medium])
				return _findMedium(m,m_start,m_end,n,n_medium+1,n_end,k-k/2);
			return m[m_medium];
		}
	}

}
