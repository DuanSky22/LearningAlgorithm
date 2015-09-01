package com.sky.learningJava.Thread;

class PrintChar implements Runnable{
	
	private char s;
	private int number;
	
	PrintChar(){}
	PrintChar(char s,int number){
		this.s=s;
		this.number=number;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<number;i++){
			System.out.print(s+" ");
		}
	}
	
}
class PrintNumber implements Runnable{
	
	private int number;
	
	PrintNumber(){}
	
	PrintNumber(int number){
		this.number=number;
	}

	@Override
	public void run() {
		Thread thread4=new Thread(new PrintChar('c',400));
		thread4.start();
		
		try {
			for(int i=0;i<number;i++){
				if(i==50) thread4.join();
				System.out.print(i+" ");
			}
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
