package com.njz.leetcode;

import javax.naming.ldap.StartTlsRequest;

public class _005_longestPalindrome {
	
	//暴力求解--超时--O(n3)
	public static String longestPalindrome1(String s){
		
		if(s == null || s.isEmpty())
			return null;
		
		int len = s.length();
		int maxPalindromeLen = 0;
		String maxPalindrome = new String();
	
		for(int i=0; i<len; i++){
			for(int j=i+1; j<=len; j++){
				String temp = s.substring(i, j);
//				System.out.println(temp);
				if(isPalindrome(temp)){
					if(temp.length() > maxPalindromeLen){
						maxPalindromeLen = temp.length();
						maxPalindrome = temp;
					}
				}
			}
		}
		
		return maxPalindrome;
	}
	
	
	//�??个O(N)时间O(N)空间的算法，即著名的Manacher算法
	public static String longestPalindrome5(String s_1){
		
		if(s_1 == null || s_1.isEmpty())
			return null;
		
		String s = processString(s_1);
		int len = s.length();
		int[] p = new int[len];
		int C = 0;
		int R = 0;
		
		//去除首位标志�??
		for(int i=1; i<len-1; i++){
			
			int i_mirror = C - (i - C);	//i'
			int diff = R-i; //右边界到i的距离，用于判断
			
			if(diff >= 0){//此时i在C和R之间，使用对称�?�质
				if(p[i_mirror]<diff)//i'是i的对称点，�?�且没有超界
					p[i] = p[i_mirror];
				else{
					p[i] = diff;//i点的值p[i]超界，需要重新求�??
					while(s.charAt(i+p[i]+1) == s.charAt(i-p[i]-1))
						p[i]++;
					C = i;//重新确定C和R的位�??
					R = C + p[i];
				}
			}
			else{//i在R右侧，超出界限，初始情况
				p[i] = 0;
				while(s.charAt(i+p[i]+1) == s.charAt(i-p[i]-1))
					p[i]++;
				C = i;//重新确定C和R的位�??
				R = C + p[i];
			}
		}//end - for
		
		//find max－－－p
		int maxLen = 0;
		int centerIndex = 0;
		for(int i=1;i<len-1; i++){
			if(maxLen < p[i]){
				maxLen = p[i];
				centerIndex = i;
			}
		}
		
		//除以2表示去掉�??有＃符号
//		return s_1.substring((centerIndex - 1 - maxLen)/2, (centerIndex - 1 - maxLen)/2 + maxLen); 
		return s.substring( (centerIndex - maxLen), (centerIndex + maxLen + 1) );        	

	}
		

	
	private static String processString(String s) {
		int n = s.length();
		
		String ret = "^";
		for (int i = 0; i < n; i++){
			ret += "#" + s.substring(i, i + 1);
		}
		         
		ret += "#$";
		return ret;
	}


	private static boolean isPalindrome(String s) {
		int len = s.length();
		for(int i=0; i<=len/2; i++){
			if(s.charAt(i) != s.charAt(len-i-1))
				return false;
		}
		return true;
	}
	
	//dp解决
	/*
	 *假设dp[ i ][ j ]的�?�为true，表示字符串s中下标从 i �?? j 的字符组成的子串是回文串。那么可以推出：
    	dp[ i ][ j ] = dp[ i + 1][ j - 1] && s[ i ] == s[ j ]�??
    	这是�??般的情况，由于需要依靠i+1, j -1，所以有可能 i + 1 = j -1, i +1 = (j - 1) -1�??
    	因此�??要求出基准情况才能套用以上的公式�??
    				a. i + 1 = j -1，即回文长度�??1时，dp[ i ][ i ] = true;
    				b. i +1 = (j - 1) -1，即回文长度�??2时，dp[ i ][ i + 1] = （s[ i ] == s[ i + 1]）�??
        动�?�规划需要额外的O(n2)的空间�??
	 */
	public static String longestPalindrome2(String S){
	 	if(S==null || S.isEmpty())
	 		return null;
	 	
		char[] s = S.toCharArray(); 
	 	int len = S.length();
	 	int dp[][] = new int[len][len];
	 	int start = 0;
	 	int max = 1;
	 	
	 	//l = 1 and 2
	 	for(int i=0; i<len; i++){
	 		dp[i][i] = 1;
	 		
	 		if(i+1 < len)
	 			if(s[i] == s[i+1]){
	 			dp[i][i+1] = 1;
	 			max = 2;
	 			start = i;
	 			}else{
	 				dp[i][i+1] = 0;
	 			}
	 	}
	 	
	 	//l > 2
	 	for(int i=3; i<=len; i++)
	 		for(int j=0; j<=len-i; j++){
	 			int k = j+i-1;//j is start; k is end;
	 			if(s[j] == s[k] && dp[j+1][k-1] == 1){
	 				dp[j][k] = 1;
	 				max = i;
	 				start = j;
	 			}else{
	 				dp[j][k] = 0;
	 			}
	 		}
	 	
		return S.substring(start, start+max);
	}
	
	//dp方法
	public static String longestPalindrome3(String s){
		if (s == null || s.length() == 0)
            return null;

		int start = 0;
        int end = 0;
        int len = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        
        for (int i=s.length()-1; i>=0; i--) 
            for (int j = i; j < s.length(); j++) {
            	
                if (i == j || (s.charAt(i) == s.charAt(j) && j - i < 2) || (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j - i + 1 > len) {
                        len = j - i;
                        start = i;
                        end = j + 1;
                    }
                }
            }
        
        return s.substring(start, end);
	}

	//dp changed
	public static String longestPalindrome7(String s){
	 	if(s==null || s.isEmpty())
	 		return "";
	 	
	 	int len = s.length();
	 	boolean dp[][] = new boolean[len][len];
	 	int start = 0;
	 	int max = 1;
	 	
	 	//l = 1 and 2
	 	for(int i=0; i<len; i++){
	 		dp[i][i] = true;
	 		
	 		if(i+1 < len)
	 			if(s.charAt(i) == s.charAt(i+1)){
	 			dp[i][i+1] = true;
	 			max = 2;
	 			start = i;
	 			}
	 	}
	 	
	 	//l > 2
	 	for(int i=3; i<=len; i++)
	 		for(int j=0; j<=len-i; j++){
	 			int k = j+i-1;//j is start; k is end;
	 			if(dp[j+1][k-1] == true && s.charAt(j) == s.charAt(k)){
	 				dp[j][k] = true;
	 				max = i;
	 				start = j;
	 			}
	 		}
	 	
		return s.substring(start, start+max);
	}


	public static String longestPalindrome4(String s){
		if(s == null || s.isEmpty())
			return null;
		
		int maxLen = 0;
		int start = 0;
		
		for(int i=0; i<s.length(); i++){
			int oddLen;
			oddLen = palindrome(s,i,i);
			
			int evenLen=0;
			if(i+1 < s.length())
				evenLen = palindrome(s, i, i+1);
		
			int curLen = oddLen>evenLen? oddLen:evenLen;
			
			if(curLen > maxLen){
				maxLen = curLen;
				if((maxLen & 1) == 1)//odd
					start = i - maxLen/2;
				else
					start = i - maxLen/2 + 1;
			}
		}
		
		return s.substring(start, start+maxLen);
	}
	
	private static int palindrome(String s, int i, int j) {
		while( i>=0 && j<s.length() && s.charAt(i) == s.charAt(j) ){
			i--;
			j++;
		}
		return (j-1)-(i+1)+1;
	}

	public static void main(String[] args){
		String rs1 = longestPalindrome1("asdfaaaaaauionkefd");
		System.out.println("rs1 : "+rs1);
		
		String rs2 = longestPalindrome2("asdfaaaaaauionkefd");
		System.out.println("rs2 : "+rs2);
		
		String rs3 = longestPalindrome3("asdfaaaaaauionkefd");
		System.out.println("rs3 : "+rs3);
		
		String rs4 = longestPalindrome4("asdfaaaaaauionkefd");
		System.out.println("rs4 : "+rs4);
		
		String rs5 = longestPalindrome5("asdfaaaaaauionkefd");
		System.out.println("rs5 : "+rs5);

	}
}
