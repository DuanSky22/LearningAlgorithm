package com.sky.learningJava.Thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExecutor {
	
	private static Account account=new Account();
	
	public static void main(String args[]){
		//为了更好的管理自己创建的多个线程，可以申请一个线程池，将这些任务放入到线程池中执行
//		ExecutorService executorService=Executors.newFixedThreadPool(2);
//		executorService.execute(new PrintChar('a',100));
//		executorService.execute(new PrintChar('b',100));
//		executorService.execute(new PrintChar('c',100));
		
		//多个线程访问共享数据时，可能造成数据不一致现象。
		//ExecutorService executor=Executors.newFixedThreadPool(1);
		ExecutorService executor=Executors.newCachedThreadPool();
		for(int i=0;i<100;i++){
			executor.execute(new AccountOperation());
		}
		executor.shutdown();
		while(!executor.isTerminated()){}
		System.out.println(account.getAccount()+"");
	}
	
	private static class AccountOperation implements Runnable{

		@Override
		public void run() {
				account.addAccount(1);
			 try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	private static class Account {
		private int balance;
		
		Account(){
			this.balance=0;
		}
		Account(int balance){
			this.balance=balance;
		}
		public synchronized void addAccount(int num){
			this.balance+=num;
		}
		public int getAccount(){
			return this.balance;
		}
		
	}

}
