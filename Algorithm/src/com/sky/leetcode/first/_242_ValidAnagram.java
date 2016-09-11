/*
 * Anagram�ǻ��ĵ���˼������ĵ�һ���㷨д���ˡ�û���������⡣
 * ��Ŀ��˼��˵��ֻ���ж������ַ����Ĺ����Ƿ�һ�������ÿ����ַ������ַ����ֵ�˳��
 * �������ǣ����������ַ����У������ǵ��Ӵ��Ƿ񶼹��ɻ��ġ�
 * ����ԭ����Ŀ��ֻ��Ҫͳ��ÿ���ַ����ֵĴ������ɡ�ʱ��Ϳռ����Ķ���o(n)
 */
package com.sky.leetcode.first;

import java.util.Arrays;

public class _242_ValidAnagram {
	
	public static void main(String args[]){
		String s="anagram";
		String t="nagamar";
		System.out.println(isAnagram(s,t));
	}
	 public static boolean isAnagram(String s, String t) {
	        if(s==null && t==null)
	            return true;
	        if((s!=null && t==null) || (s==null && t!=null))
	            return false;
	        if(s.length()!=t.length())
	            return false;
	        int n=s.length();
	        int[] sCounter=new int[26];
	        int[] tCounter=new int[26];
	        for(int i=0;i<n;i++){
	            sCounter[s.charAt(i)-'a']+=1;
	            tCounter[t.charAt(i)-'a']+=1;
	        }
	        for(int i=0;i<26;i++){
	            if(sCounter[i]!=tCounter[i])
	                return false;
	        }
	        return true;
	    }
	 

		/*
		 * here we allocate 26 int array to store every alpha show times.
		 * time complex : o(m+n)
		 */
		
		public boolean isAnagram0(String s,String t){
			int[] result=new int[26];
			for(int i=0;i<s.length();i++)
				result[s.charAt(i)-'a']++;
			for(int j=0;j<t.length();j++)
				result[s.charAt(j)-'a']--;
			for(int i=0;i<result.length;i++)
				if(result[i]!=0)
					return false;
			return true;
		}
		/*
		 * sort and compare
		 * time complex o(nlgn)
		 */
		public boolean isAnagram1(String s, String t) {
	        if((s==null && t!=null) || (s!=null && t==null))
	            return false;
	        if(s==t)
	            return true;
	        if(s.length()!=t.length())
	            return false;
	        char[] temp_s=s.toCharArray();
	        Arrays.sort(temp_s);
	        char[] temp_t=t.toCharArray();
	        Arrays.sort(temp_t);
	        for(int i=0;i<temp_s.length;i++){
	        	if(temp_s[i]!=temp_t[i])
	        		return false;
	        }
	        return true;
	    }
	/*
	public static boolean isAnagram(String s,String t){
		boolean finalResult=true;
		if(s==null && t==null)
			return true;
		if((s==null && t!=null) || (s!=null && t==null))
			return false;
		if(s.length()!=t.length())
			return false;
		int n=s.length();
		if(n==1)
			return s.equals(t);
		int start=0;
		int end=start+1;
		while(start<n){
			boolean tempResult=false;
			for(end=start+1;end<n;end++){
				//test s[start,...,end]=t[end,...,start]
				boolean testResult=true;
				for(int offset=0;offset<=end-start;offset++){
					if(s.charAt(start+offset)!=t.charAt(end-offset)){
						testResult=false;
						break;
					}
				}
				tempResult=tempResult || testResult;
				if(testResult){
					start=end+1;
					break;
				}
			}
			finalResult=finalResult && tempResult;
			if(end==n)
				break;
		}
		return finalResult;
	}
	*/

}
