package com.sky.learningJava.Thread;

public class ThreadIntro {
	
	public static void main(String args[]){
		
		PrintChar task1=new PrintChar('a',100);
		PrintChar task2=new PrintChar('b',100);
		PrintNumber task3=new PrintNumber(100);
		
		Thread thread1=new Thread(task1);
		Thread thread2=new Thread(task2);
		Thread thread3=new Thread(task3);
		
//		thread1.start();
//		thread2.start();
//		thread3.start();
		thread1.run();
		thread2.run();
		thread3.run();
		//thread3.setPriority(Thread.MAX_PRIORITY);
		
	}
	
	

}
