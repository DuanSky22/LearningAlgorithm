package com.sky.learningJava.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
	private static Lock lock=new ReentrantLock();
	private static Condition full=lock.newCondition(); //缓冲区满
	private static Condition empty=lock.newCondition(); //缓冲区空
	private static final int CAPACITY=10;
	private List<Integer> list;
	private int currentSize=0;
	Buffer(){
		list=new ArrayList<Integer>();
		this.currentSize=0;
	}
	public void read(){
		lock.lock(); //进来之前先上锁，同一时刻只能有一个进程来读缓冲区
		while(this.currentSize==0){ //如果目前的缓冲区为空，则读的进程需要等待。
			try {
				empty.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("您读取的内容为："+list.get(currentSize-1));
		list.remove(currentSize-1);
		currentSize--;
		full.signalAll();
		lock.unlock();
	}
	public void write(Integer i){
		lock.lock();
		while(this.currentSize==Buffer.CAPACITY){//如果缓冲区已经满，则写的进程等待
			try {
				full.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("          您写入的内容为："+i);
		list.add(i);
		currentSize++;
		empty.signalAll();
		lock.unlock();
	}
}
