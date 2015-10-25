/**
* @author DuanSky
* @date 2015年10月24日 下午2:26:21
* @content 
*/
package com.sky.leetcode;

import java.io.File;

public class SearchEngine {
	
	public static void main(String args[]){
		String key="ingle";
		String path=SearchEngine.class.getClassLoader().getResource("").getPath();
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
