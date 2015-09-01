package com.sky.learningJava.Thread02;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountWithLock {
	
	private int amount=0;
	
	private Lock lock=new ReentrantLock();

}
