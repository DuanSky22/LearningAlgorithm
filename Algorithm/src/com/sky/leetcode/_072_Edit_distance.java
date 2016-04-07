package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2016年3月25日 下午4:47:26
 * @content 
 */

public class _072_Edit_distance {
	
	public static void main(String args[]){
		_072_Edit_distance test = new _072_Edit_distance();
		String word1 = "ac";
		String word2 = "abcde";
		System.out.println(test.minDistance_(word1, word2));
	}
	
	//采用一位数组存储数据
	public int minDistance_(String word1,String word2){
      if(word1 == null || word2 == null || word1.length() == 0 || word2.length() == 0) 
        	return Math.max(word1 == null ? 0 : word1.length(), word2 == null ? 0 : word2.length());
      //保证小端在前，大端在后
      if(word1.length() < word2.length()){
    	  String temp = word1;
    	  word1 = word2;
    	  word2 = temp;
      }
      int[] d = new int[word2.length()+1];
      int last = 0, curr = 0;
      for(int i = 0; i <= word1.length(); i++){
    	  for(int j = 0; j <= word2.length(); j++){
    		  if(i == 0) d[j]=j; //初始化第一行的数据
    		  else if(j == 0)  last = i;
    		  else{
    			  curr =  Math.min(d[j-1]+(word1.charAt(i-1)==word2.charAt(j-1) ? 0 : 1),Math.min(last, d[j])+1);
    			  d[j-1] = last; 
    			  last = curr;
    			  if(j == word2.length()) d[j] = curr;
    		  }
    	  }
      }
      return d[word2.length()];
	}
	
	//采用二维数组存储数据，空间复杂度和时间复杂度均为 o(mn)
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
