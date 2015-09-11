/**
* @author DuanSky
* @date 2015年9月10日 下午11:16:05
* @content 
*/
package com.sky.learningJava.memory;

public class JavaVMStackOOM {
	private int counter=1;
	private void dontStop(){
		counter++;
		while(true){
			
		}
	}
	public void stackLeakByThread(){
		while(true){
			Thread thread=new Thread(new Runnable(){
				@Override
				public void run() {
					dontStop();
				}
			});
		}
	}
	public static void main(String args[]){
		JavaVMStackOOM oom=new JavaVMStackOOM();
		oom.stackLeakByThread();
	}
}
