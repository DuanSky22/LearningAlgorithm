package com.sky.topic.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Alphabet {

	private Map<Character,Integer> ci = new HashMap<>();
	private Map<Integer,Character> ic = new HashMap<>();
	
	private static int R = 0;
	
	//this()和super()都必须放在构造函数的第一行使用
	public Alphabet(String[] a){
		StringBuilder sb = new StringBuilder();
		for(String s : a)
			sb.append(s);
		init(sb.toString());
	}
	
	public Alphabet(String s){
		init(s);
	}
	
	private void init(String s){
		if(s == null || s.length() == 0) return;
		Set<Character> set = new HashSet<Character>();
		for(int i = 0; i < s.length(); i++)
			set.add(s.charAt(i));
		List<Character> list = new ArrayList<>(set);
		Collections.sort(list); //排序
		for(char c : list){
			ci.put(c, R);
			ic.put(R++, c);
		}
	}
	
	public char toChar(int index){
		if(ic.containsKey(index)) return ic.get(index);
		else return 0;
	}
	
	public int toIndex(char c){
		if(ci.containsKey(c)) return ci.get(c);
		else return -1;
	}
	
	public boolean contains(char c){
		return ci.containsKey(c);
	}
	
	public int R(){
		return R;
	}
	
	public int lgR(){
		return (int)Math.ceil(Math.log(R));
	}
	
	public int[] toIndices(String s){
		int[] res = new int[s.length()];
		for(int i = 0; i < s.length(); i++){
			res[i] = ci.get(s.charAt(i));
		}
		return res;
	}
	
	public String toChars(int[] indices){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < indices.length; i++){
			sb.append(ic.get(indices[i]));
		}
		return sb.toString();
	}
	
}
