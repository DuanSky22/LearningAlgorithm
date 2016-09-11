/**
* @author DuanSky
* @date 2015��12��8�� ����10:02:38
* @content 
*/
package com.sky.leetcode.first;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _187_RepeatedDNASequences {
	
	public static void main(String args[]){
		String s = "AAAAAAAAAAAAA";
		System.out.println(findRepeatedDnaSequences(s));
	}
	
	
	public static List<String> findRepeatedDnaSequences(String s){
		Map<Integer,Boolean> words=new HashMap<Integer,Boolean>();
		List<String> result=new ArrayList<String>();
		int[] map=new int[26];
		map['A'-'A']=0;map['C'-'A']=1;map['G'-'A']=2;map['T'-'A']=3;
		for(int i=0;i<s.length()-9;i++){
			int word=0;
			for(int j=i;j<i+10;j++){
				word<<=2;//�ϴ��ַ�������λ
				word+=map[s.charAt(j)-'A'];
			}
			if(words.containsKey(word)){
				if(words.get(word)){
					result.add(s.substring(i,i+10));
					words.put(word, false);
				}
			}
			else
				words.put(word, true);
		}
		return result;
	}
	
	/*
	 * ��׼��
	 * 1. ��10���ַ�ӳ�䵽�����ϣ����Դ��򻯱Ƚϵ��ٶȣ�
	 * 2. ����˫���Ͽ�������������ж��Ӵ�ǡ���ڳ������ε�ʱ����ӣ��ڳ���һ�κ����ε�ʱ�򶼲���ӡ�
	 */
	public static List<String> findRepeatedDnaSequences_Answer(String s) {
	    Set<Integer> words = new HashSet<>();
	    Set<Integer> doubleWords = new HashSet<>();
	    List<String> rv = new ArrayList<>();
	    char[] map = new char[26];
	    //map['A' - 'A'] = 0;
	    map['C' - 'A'] = 1;
	    map['G' - 'A'] = 2;
	    map['T' - 'A'] = 3;

	    for(int i = 0; i < s.length() - 9; i++) {
	        int v = 0;
	        for(int j = i; j < i + 10; j++) {
	            v <<= 2;
	            v |= map[s.charAt(j) - 'A'];
	        }
	        if(!words.add(v) && doubleWords.add(v)) {//��ֵ���㣬�����߷���Ϊ�գ��Ͳ�����ִ���ұ�
	            rv.add(s.substring(i, i + 10));
	        }
	    }
	    return rv;
	}
	
	//o(n^2)���Ӷ�
	public static List<String> findRepeatedDnaSequences_TimeLimited(String s) {
		Set<String> result=new HashSet<String>();
        if(s.length()<20)
        	return new ArrayList<String>(result);
        for(int i=0;i<s.length()-20;i++){
        	String test=s.substring(i,i+10);
        	if(result.contains(test))
        		continue;
        	for(int j=i+10;j<s.length()-10;j++){
        		String iscopy=s.substring(j,j+10);
        		if(test.equals(iscopy)){
        			result.add(test);
        			break;
        		}
        	}
        }
        return new ArrayList<String>(result);
    }

}
