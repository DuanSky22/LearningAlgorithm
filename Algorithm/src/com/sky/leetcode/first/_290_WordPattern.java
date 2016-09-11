/**
* @author DuanSky
* @date 2015��10��9�� ����5:33:19
* @content 
*/
package com.sky.leetcode.first;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class _290_WordPattern {
	
	public static void main(String args[]){
		String pattern="abba";
		String str="dog dog dog dog";
		System.out.println(wordPattern(pattern,str));
	}

	/*
	 * here what we should specifically take care of is that pattern and str is strong relationship.
	 * Which means that if one of pattern (like a) indicated a string (like dog), this string(dog) must also
	 * indicated that character(a). In other word, a<=>dog.
	 * How to identify this relationship is the key of the word pattern problem.
	 */
	public static boolean  wordPattern(String pattern, String str) {
        if(pattern.length()==0 || str.length()==0)
            return false;
        String[] arrays=str.split(" ");
        if(pattern.length()!=arrays.length)
        	return false;
        Map<Character,String> charToString=new HashMap<Character,String>();
        Map<String,Character> stringToChar=new HashMap<String,Character>();
        for(int i=0;i<pattern.length();i++){
        	char c=pattern.charAt(i);
        	String s=arrays[i];
        	if(charToString.containsKey(c) || stringToChar.containsKey(s))
        		if(charToString.containsKey(c) && stringToChar.containsKey(s) && stringToChar.get(s).equals(c) && charToString.get(c).equals(s))
        			continue;
        		else
        			return false;
        	else{
        		charToString.put(c, s);
        		stringToChar.put(s, c);
        	}
        }
        return true;
    }
	
	public static boolean wordPattern0(String pattern, String str) {
	    String[] words = str.split(" ");
	    if (words.length != pattern.length())
	        return false;
	    Map index = new HashMap();
	    for (int i=0; i<words.length; ++i)
	        if (!Objects.equals(index.put(pattern.charAt(i), i),
	                            index.put(words[i], i)))
	            return false;
	    return true;
	}
}
