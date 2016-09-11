package com.sky.leetcode.first;

import java.util.Stack;

/**
 * @author DuanSky
 * @date 2015年12月14日 下午11:08:45
 * @content 
 */

public class _071_SimplifyPath {
	
	public static void main(String args[]){
		String path="/...";
		System.out.println(simplifyPath_with_stack(path));
	}
	
	//使用栈
	public static String simplifyPath_with_stack(String path){
		Stack<String> result=new Stack<String>(); 
		int start=0;int end=0;
		while(end<path.length()-1){ //注意这里判断的时候需要-1
			start=path.indexOf('/',end);
			end=path.indexOf('/', start+1)==-1? path.length() : path.indexOf('/', start+1); //注意这里截取时候不能-1！
			if(start==path.length()-1) break;
			if(end-start==1 || path.substring(start+1, end).equals(".")) //注意这里start需要+1.
				continue;
			else if(path.substring(start+1,end).equals("..")){
				if(!result.isEmpty()) //这里需要判断是否为空
					result.pop();
			}
			else
				result.push(path.substring(start,end));
		}
		String newPath="";
		while(!result.isEmpty())
			newPath=result.pop()+newPath;
		return newPath.isEmpty() ? "/" : newPath;
	}
	
	//不使用栈
	public static String simplifyPath(String path) {
        String result="";int i=0;
        while(i<path.length()){
        	int start=i++; //第一个出现"/"字符的位置
        	while(i<path.length() && path.charAt(i)!='/') i++;
        	int end=i; //第二次出现字符"/"的位置 //两个字符之间只出现一个点，表示当前路径
        	if(start+1==end ||(start+2==end && path.charAt(start+1)=='.'))// "//"出现了两次
        		continue;      	
        	else if(start+3==end && path.charAt(start+1)=='.' && path.charAt(start+2)=='.'){//两个字符之间出现了两个点，表示上一级目录
        		//如何恢复到上一层目录？
        		int j=result.length()-1;
        		for(;j>0;j--){
        			if(result.charAt(j)=='/')
        				break;
        		}
        		result=result.length()==0 ? "" : result.substring(0,j);
        	}
        	else 
        		result+=path.substring(start,end);
        }
        return result.length()==0? "/" : result;
    }

}
