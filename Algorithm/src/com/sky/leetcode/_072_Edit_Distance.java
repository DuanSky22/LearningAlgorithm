package com.sky.leetcode;

public class _072_Edit_Distance {

	public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null || word1.length() == 0 || word2.length() == 0) 
        	return Math.max(word1 == null ? 0 : word1.length(), word2 == null ? 0 : word2.length());
        int[][] distance = new int[word1.length()+1][word2.length()+1];
        for(int i = 0; i <= word1.length(); i++){ //i表示截取前几个元素
        	for(int j = 0; j <= word2.length(); j++){
        		if(i == 0 || j == 0) distance[i][j] = Math.max(i, j);
        		else
        			distance[i][j] = Math.min(distance[i-1][j-1]+(word1.charAt(i-1) == word2.charAt(j-1) ? 0 : 1), 
        					Math.min(distance[i-1][j]+1,distance[i][j-1]+1));
        	}
        }
        return distance[word1.length()][word2.length()];
    }
}
