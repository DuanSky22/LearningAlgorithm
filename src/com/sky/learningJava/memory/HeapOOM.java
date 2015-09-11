/**
* @author DuanSky
* @date 2015年9月10日 下午10:55:19
* @content 
*/
package com.sky.learningJava.memory;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {
	static class OOMObject{}
	
	public static void main(String args[]){
		List<OOMObject> list=new ArrayList<OOMObject>();
		while(true){
			list.add(new OOMObject());
		}
	}
}
