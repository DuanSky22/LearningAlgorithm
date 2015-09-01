package com.sky.learningJava.Thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockingQueueTest {
	
	private static BlockingQueueIntro bq=new BlockingQueueIntro();
	
	public static void main(String args[]){
		ExecutorService es=Executors.newCachedThreadPool();
		for(int i=0;i<100;i++){
			es.execute(new ReadTask());
			es.execute(new WriteTask());
		}
		es.shutdown();
	}
	
	
	private static class ReadTask implements Runnable{

		@Override
		public void run() {
			try {
				bq.read();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	private static class WriteTask implements Runnable{

		@Override
		public void run() {
			try {
				bq.write(new Random().nextInt(100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	

}
