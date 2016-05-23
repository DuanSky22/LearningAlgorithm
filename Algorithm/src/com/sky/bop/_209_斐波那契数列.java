package com.sky.bop;

public class _209_斐波那契数列 {
	
	public static void main(String args[]){
		_209_斐波那契数列 test = new _209_斐波那契数列();
		int n = 24;
		System.out.println(
				test.f0(n) +" "+
				test.f1(n) +" "+
				test.f2(n) 
				);
	}
	
	//采用定义计算
	public int f0(int n){
		if(n <= 1) return n;
		return f0(n-1) + f0(n-2);
	}
	//采用数组，省去递归
	public int f1(int n){
		int f[] = new int[n+1];
		f[1] = 1;
		for(int i = 2; i <=n; i++)
			f[i] = f[i-1] + f[i-2];
		return f[n];
	}
	//采用两个临时变量，省去数组
	public int f2(int n){
		int a = 0;
		int b = 1;
		if(n == 0) return a;
		else if(n == 1) return b;
		for(int i = 2; i <= n; i++){
			if((i & 1) == 0) a = a + b;
			else b = a + b;
		}
		return Math.max(a, b);
	}

}
