/**
* @author DuanSky
* @date 2015年9月10日 下午11:07:29
* @content 
*/
package com.sky.learningJava.memory;

public class JavaVMStackSOF {
	private int stackLength=1;
	
	public void stackLeak(){
		stackLength++;
		stackLeak();
	}
	
	public static void main(String args[]){
		JavaVMStackSOF oom=new JavaVMStackSOF();
		try{
		oom.stackLeak();
		}catch(Throwable e){
			System.out.println(oom.stackLength);
			throw e;
		}
	}

}
