package com.sky.learningJava.Thread02;

public class Account {

	private int amount=0;
	
	synchronized  public void withdraw(int money){
		while(this.amount<money){
			try {
				System.out.println("钱不够，该进程被阻塞");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.amount-=money;
		System.out.println("取钱："+money);
		System.out.println("--------卡里余额："+amount);
	}
	synchronized public void save(int money){
		this.amount+=money;
		System.out.println("存钱："+money);
		System.out.println("--------卡里余额："+amount);
		notifyAll();
	}
	public int getAmount() {
		return amount;
	}
}
