package com.sky.bop;

public class _201_number_of_1 {
	
	public static void main(String args[]){
		_201_number_of_1 test = new _201_number_of_1();
		System.out.println(Integer.toBinaryString(-2));
		int n = 2;
		test.print();
		//System.out.println(test.solution0(n)+":"+test.solution(n));
	}
	
	
	public void print(){
		for(int i = 0; i < 10; i++){
			System.out.println(i&(-i));
		}
	}
	
	public int solution(int n){
		int counter = 0;
		while(n != 0){
			counter += n & 1;
			n >>>= 1;
		}
		return counter;
	}
	
	public int solution0(int n){
		int counter = 0;
		while(n != 0){
			n &= (n-1);
			counter++;
		}
		return counter;
	}

}
