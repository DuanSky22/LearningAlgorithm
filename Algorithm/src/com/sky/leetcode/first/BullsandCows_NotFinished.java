/**
* @author DuanSky
* @date 2015��11��2�� ����10:38:35
* @content 
*/
package com.sky.leetcode.first;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BullsandCows_NotFinished {
	
	public static void main(String args[]){
		String secret="1234";
		String guess="0111";
		System.out.println(getHint(secret,guess));
	}
	
	 public static String getHint(String secret, String guess) {
	        Map<Character,Set<Integer>> map=new HashMap<Character,Set<Integer>>();
	        int a=0;int b=0;
	        for(int i=0;i<secret.length();i++){
	            char c=secret.charAt(i);
	            if(map.containsKey(c)){
	                map.get(c).add(i);
	            }
	            else{
	                Set<Integer> s=new HashSet<Integer>();
	                s.add(i);
	                map.put(c,s);
	            }
	        }
	        for(int i=0;i<guess.length();i++){
	            char c=guess.charAt(i);
	            if(map.containsKey(c) && !map.get(c).isEmpty()){
	            	//System.out.println(map.get(c).isEmpty());
	            	b++;
	                if(map.get(c).contains(i))
	                    a++;
	            }
	        }
	        return a+"A"+(b-a)+"B";
	    }

}
