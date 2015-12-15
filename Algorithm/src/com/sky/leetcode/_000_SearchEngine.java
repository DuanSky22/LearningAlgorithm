/**
* @author DuanSky
* @date 2015��10��24�� ����2:26:21
* @content 
*/
package com.sky.leetcode;

import java.io.File;

public class _000_SearchEngine {
	
	public static void main(String args[]){
		String key="Search";
		String path=_000_SearchEngine.class.getClassLoader().getResource("").getPath();
		search(path,key);
	}
	
	public static void search(String path,String key){
		File file=new File(path);
		if(file.isDirectory()){
			for(String single : file.list()){
				search(path+File.separator+single,key);
			}
		}
		else
			if(file.getName().contains(key))
				System.out.println(file.getName());
	}

}
