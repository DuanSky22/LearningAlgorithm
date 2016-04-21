package com.sky.bop;

public class _202_不要被阶乘吓倒 {
	
	public static void main(String args[]){
		_202_不要被阶乘吓倒 test = new _202_不要被阶乘吓倒();
		int n = 30	;
		System.out.println(test.solution0(n));
	}
	
	//抽象为更一般的问题 N!中因子k的指数是多少？
	public int solution2(int n,int k){
		if(k == 1) return Integer.MAX_VALUE;
		if(k < 1) return 0;
		int counter = 0;
		while(n != 0){
			counter += n/k;
			n /= k;
		}
		return counter;
	}
	
	//该题转化为的同质问题是 N!中包含的因子5的指数是多少。
	public int solution1(int n){
		int counter = 0;
		while(n != 0){
			counter += n/5; 
			n /= 5;
		}
		return counter;
	}
	public int solution0(int n){
		int counter = 0;
		for(int i = 1; i < n; i++){
			int j = i;
			while(j/5 != 0){ //逐个统计每个因子i有多少个5.
				counter++;
				j /= 5;
			}
		}
		return counter;
	}
	//wrong solution! 
	public int wrongSolution(int n){
		int counter = 0;
		while(true){
			if(n < 10)
				return counter + (n < 5 ? 0 : 1);
			counter += (n/10)*2;
			n %= 10;
		}
	}
}
