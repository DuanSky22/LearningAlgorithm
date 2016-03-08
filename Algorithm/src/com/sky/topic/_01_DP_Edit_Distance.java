package com.sky.topic;
/**
 * @author DuanSky
 * @date 2016年1月19日 下午5:29:00
 * @content 
 */

public class _01_DP_Edit_Distance {
	
	public static void main(String args[]){
		_01_DP_Edit_Distance test = new _01_DP_Edit_Distance();
		String s = "abacd";
		String t = "abaefggd";
		System.out.println(test.getEditDistance(s, t));
	}
	
	public int getEditDistance(String s,String t){
		if( s == null || s.length() ==0) return t==null ? 0 : t.length();
		int d[][] = new int[s.length()+1][t.length()+1];
		//初始化
		for(int i=0;i<s.length();i++) d[i][0]=i;
		for(int j=0;j<t.length();j++) d[0][j]=j;
		//动态规划
		for(int i=0;i<s.length();i++){
			for(int j=0;j<t.length();j++){
				if(s.charAt(i)==t.charAt(j))
					d[i+1][j+1]=Math.min(d[i][j], Math.min(d[i][j+1]+1,d[i+1][j]+1));
				else
					d[i+1][j+1]=Math.min(d[i][j], Math.min(d[i][j+1], d[i+1][j]))+1;
			}
		}
		return d[s.length()][t.length()];
	}

}
