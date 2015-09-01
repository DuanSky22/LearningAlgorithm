package com.sky.learningJava.Thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueIntro {
	
	//private static Lock lock=new ReentrantLock();
	private static LinkedBlockingQueue<Integer> lbq=new LinkedBlockingQueue<Integer>(10);
	
	
	public void read() throws InterruptedException{
		//注意，这里不能使用加锁的机制。
		/*
		 * 例如这种情况：如果Read()方法先执行，首先队列为空，lbq.take()被阻塞，而它又不像condition那样可以释放锁。
		 * 所以导致原对象 bq被锁住，且不能执行到lock.unlock()，导致write()方法也不能被执行。所以一直处于死锁状态。
		 * 根本原因是lbq.take()被阻塞后，没有释放锁的动作。
		 */
		//lock.lock();
		Integer top=(Integer)lbq.take();
		System.out.println("您读取的内容为："+top.toString());
		//lock.unlock();
	}
	public void write(Integer i) throws InterruptedException{
		//lock.lock();
		lbq.put(i);
		System.out.println("     您写入的内容为："+i.toString());
		//lock.unlock();
	}
}
