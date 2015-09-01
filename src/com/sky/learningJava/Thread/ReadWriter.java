package com.sky.learningJava.Thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReadWriter {

	private static Buffer buffer=new Buffer();
	
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
			buffer.read();
		}
	}
	private static class WriteTask implements Runnable{

		@Override
		public void run() {
			buffer.write(new Random().nextInt(100));
		}
		
	}
}
