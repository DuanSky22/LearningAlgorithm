package com.sky.learningJava.Thread02;

import java.util.Date;


public class ThreadIntro extends Thread{
	public static void main(String args[]){
		ThreadIntro t1=new ThreadIntro("DuanSky");
		ThreadIntro t2=new ThreadIntro("SkyDream");
		t1.start();
		t2.start();
	}
	ThreadIntro(String name){
		super(name);
	}
	public void run(){
		while(true){
			System.out.println(super.getName() + ":" + new 
                    Date(System.currentTimeMillis()));
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
