package com.sky.learningJava.Thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadCommunication {
	
	private static Account account=new Account();
	
	public static void main(String args[]){

		ExecutorService es=Executors.newCachedThreadPool();
		for(int i=0;i<100;i++){
			es.execute(new InputMoneyTask());
			es.execute(new OutPutMoneyTask());
		}
		es.shutdown();
	}

	private static class InputMoneyTask implements Runnable{
		@Override
		public void run() {
			account.saveMoney(new Random().nextInt(100));
		}
	}
	private static class OutPutMoneyTask implements Runnable{

		@Override
		public void run() {
			account.withdraw(new Random().nextInt(100));
		}
		
	}
}
