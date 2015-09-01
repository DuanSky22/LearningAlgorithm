package com.sky.learningJava.Thread02;

import java.util.Date;

public class TaskIntro implements Runnable{
	public static void main(String args[]){
		TaskIntro task1=new TaskIntro("DuanSky");
		TaskIntro task2=new TaskIntro("SkyDream");
		Thread t1=new Thread(task1);
		Thread t2=new Thread(task2);
		t1.start();t2.start();
	}
	private String name;
	public TaskIntro(String name) {
		this.name=name;
	}
	@Override
	public void run() {
		while(true){
			System.out.println(getName()+new Date());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
