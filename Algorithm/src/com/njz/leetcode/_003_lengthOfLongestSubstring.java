package com.njz.leetcode;

public class _003_lengthOfLongestSubstring {
	
	//贪心算法
	//�??�??个数组记录当前字符最近出现的位置，一遍算过去，更新左边界，用计算�??大�?�就行了�??
	public static int lengthOfLongestSubstring(String s){
		int len = 0, left = 0;  
        int prev[] = new int[300]; //asc码使�??
  
        // init prev array  
        for (int i = 0; i < 300; ++i)  
            prev[i] = -1;  
  
        for (int i = 0; i < s.length(); ++i) {  
            if (prev[s.charAt(i)] >= left)//当前这个字符出现�??
                left = prev[s.charAt(i)] + 1;//更新�??始位�??
            
            prev[s.charAt(i)] = i;  
            
            if (len < i - left + 1)  
                len = i - left + 1;  
        }  
        return len;  
	}
	
	public static void main(String[] args){
		String s = new String("njzabc");
		int rs = lengthOfLongestSubstring(s);
		System.out.println(rs);
	}
}
