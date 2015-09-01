package com.sky.learningJava.Thread;

public class ThreadHomework implements Runnable{
	
	public static void main(String args[]){
		new ThreadHomework();
	}

	public ThreadHomework(){
		Thread t=new Thread(this);
		t.start();
		//t.start();
		
	}
	@Override
	public void run() {
		System.out.println("test");
	}
	

}
