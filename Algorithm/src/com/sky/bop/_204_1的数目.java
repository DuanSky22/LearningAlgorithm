package com.sky.bop;

public class _204_1的数目 {
	
	public static void main(String args[]){
		_204_1的数目 test = new _204_1的数目();
		int n = 123;
		System.out.println(test.solution(n));
	}

	//按照个位、十位、百位等等逐位统计1的数目
	public int solution(int n){
		int counter = 0,  base = 1;
		while(n / base != 0){
			int currNum = (n / base) % 10;//获取当前位上的数字
			if(currNum == 0)
				counter += n/(10*base)*base;
			else if(currNum == 1) 
				counter += n/(10*base)*base + n%base + 1;
			else
				counter += (n/(10*base)+1)*base;
			base *= 10;
			
		}
		return counter;
	}
}
