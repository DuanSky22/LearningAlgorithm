/*
 * Anagram�ǻ��ĵ���˼������ĵ�һ���㷨д���ˡ�û���������⡣
 * ��Ŀ��˼��˵��ֻ���ж������ַ����Ĺ����Ƿ�һ�������ÿ����ַ������ַ����ֵ�˳��
 * �������ǣ����������ַ����У������ǵ��Ӵ��Ƿ񶼹��ɻ��ġ�
 */
package com.sky.leetcode;

public class _003_ValidAnagram {
	
	public static void main(String args[]){
		String s="anagram";
		String t="nagamar";
		System.out.println(isAnagram(s,t));
	}
	
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

}
