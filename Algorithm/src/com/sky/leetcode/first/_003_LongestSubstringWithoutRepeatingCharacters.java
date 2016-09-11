package com.sky.leetcode.first;

/**
 * �����Ѱ������ظ����Ӵ������Բ��ö�̬�滮��˼�룬��������ָ�룬һ��ָ��Ŀǰ�ӶεĿ�ͷ��һ��ָ�����ڼ����ַ���
 * �������ַ���ǰ����Ӷ��в����ڣ�����Խ�����ַ����뵽�Ӷ��У�ͬʱ��󳤶�+1;�������ַ���ǰ����Ӵ����Ѿ����֣���˵��
 * ���Ӵ�����������������䳤�ȣ�������Ӵ�ֵ��ͬʱ��startָ��ָ���ڸ��Ӵ��г��ָ��ַ�����һ��λ�ã�����������
* @author DuanSky
* @date 2015��12��7�� ����10:50:28
* @content 
*/

public class _003_LongestSubstringWithoutRepeatingCharacters {

	
	public static void main(String args[]){
		String s="abfdda";
		System.out.println(lengthOfLongestSubstring(s));
	}
	
	public static int lengthOfLongestSubstring(String s) {
		if(s==null || s.length()==0) return 0;
        int max=1;int start=0;
        for(int i=1;i<s.length();i++){
        	char c=s.charAt(i);
        	int position=0;
        	if((position=s.substring(start,i).indexOf(c))==-1){
        		if(i-start+1>max) //update max
        			max=i-start+1;
        	}
        	else
        		start=start+position+1;
        }
        return max;
    }
}
