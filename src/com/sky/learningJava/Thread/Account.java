package com.sky.learningJava.Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

	private static Lock lock=new ReentrantLock();//声明一个锁
	private static Condition condition=lock.newCondition();//声明一个condition
	
	private int balance=0;
	
	public void saveMoney(int inputMoney){
		lock.lock();
		balance+=inputMoney;
		System.out.println("您存了"+inputMoney+"钱，账户还剩"+balance+"钱");
		condition.signalAll();
		lock.unlock();
	}
	
	public void withdraw(int outputMoney){
		lock.lock();
		while(outputMoney>this.balance){
			try {
				condition.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		balance-=outputMoney;
		System.out.println("您取了"+outputMoney+"钱，账户还剩"+balance+"钱");
	}
	
}
