package com.sky.topic.dynamic_programming;
/**
 * @author DuanSky
 * @date 2016年3月5日 下午9:17:12
 * @content 
 * d[i][j]表示a串的前i个元素和b串的前j个元素的LCS长度.
 */

public class _01_DP_longest_common_subsequence {
	
	public static void main(String args[]){
		_01_DP_longest_common_subsequence test = new _01_DP_longest_common_subsequence();
		String a = "cdba";
		String b = "abcd";
		System.out.println(test.solution(a, b));
		
	}
	
	public int solution(String a,String b){
		if(a==null || b==null ||a.length()==0 || b.length()==0) return 0;
		int[][] d = new int[a.length()+1][b.length()+1];
		for(int i=0;i<a.length();i++){
			for(int j=0;j<b.length();j++){
				d[i+1][j+1] = Math.max(d[i][j+1], Math.max(d[i+1][j], d[i][j] + (a.charAt(i)==b.charAt(j) ? 1 : 0)));
			}
		}
		return d[a.length()][b.length()];
	}
}
