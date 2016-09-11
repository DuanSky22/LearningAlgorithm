package com.sky.leetcode.first;

import java.util.Scanner;

public class SW_1 {
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		int testNums = scanner.nextInt();
		int i = 0; 
		while(i++ < testNums){
			int N = scanner.nextInt();
			int P = scanner.nextInt();
			int W = scanner.nextInt();
			int H = scanner.nextInt();
			int total = 0;
			int[] pags = new int[N];
			for(int j = 0; j < N; j++){
				pags[j] = scanner.nextInt();
				total += pags[j];
			}
			int res = (int)Math.sqrt(W * H * P / total);
			
			while(!isValid(pags,N,W,P,H,res)) res--;
			System.out.println(res);
		}
	}
	
	public static boolean isValid(int[] pags, int N, int W, int P, int H,int res){
		int lines = 0;
		for(int k = 0; k < N; k++){
			lines += pags[k] / ( W / res);
		}
		return P >= lines / ( H / res);
	}
}
