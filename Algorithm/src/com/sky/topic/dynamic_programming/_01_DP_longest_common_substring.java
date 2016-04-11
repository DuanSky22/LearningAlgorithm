package com.sky.topic.dynamic_programming;
/**
 * @author DuanSky
 * @date 2016年3月5日 下午9:02:17
 * @content 
 * d[i][j]表示a串以第i个元素结尾，b串以第j个元素结尾时的LCS.
 */

public class _01_DP_longest_common_substring {
	
	public static void main(String args[]){
		_01_DP_longest_common_substring test = new _01_DP_longest_common_substring();
		String a= "12346";
		String b = "234";
		System.out.println(test.solution(a, b));
	}
	
	public int solution(String a,String b){
		if(a==null || a.length()==0 || b==null || b.length()==0) return 0;
		int max = 0;
		int[][] d = new int[a.length()+1][b.length()+1];
		for(int i=0;i<a.length();i++){
			for(int j=0;j<b.length();j++){
				d[i+1][j+1] = a.charAt(i)==b.charAt(j) ? d[i][j]+1 : 0;
				max = Math.max(d[i+1][j+1], max);
			}
		}
		return max;
	}

}
