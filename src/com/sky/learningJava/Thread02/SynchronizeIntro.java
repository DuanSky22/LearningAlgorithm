package com.sky.learningJava.Thread02;

import java.util.Random;

public class SynchronizeIntro{
	public static Account account=new Account();
	
	public static void main(String args[]) throws InterruptedException{
		Thread t1=new Thread(new WithDraw());
		//Thread t2=new Thread(new Save());
		t1.start();
		//t2.start();
		//由以下代码可以看出线程可以访问非Synchronize关键字修饰的方法，即使这个对象已经被锁住。
		Thread.sleep(1000);
		System.out.println(account.getAmount());
		
	}

	
	static class WithDraw implements Runnable{
		@Override
		public void run() {
			while(true){
				account.withdraw(new Random().nextInt(10));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	static class Save implements Runnable{

		@Override
		public void run() {
			while(true){
				account.save(new Random().nextInt(10));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
				
			
		}
		
	}
	

}
