package com.sky.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author DuanSky
 * @date 2016年1月14日 下午4:35:19
 * @content 
 * [186,419,83,408]
6249
 * 	本题容易落入贪心陷阱：面额大的硬币，并非越多越好！
 */

public class _322_Coin_Change {
	
	public static void main(String args[]){
		_322_Coin_Change test = new _322_Coin_Change();
		int[] coins = {186,419,83,408};
		int amount =624;
		System.out.println(test.coinChange(coins, amount));
		System.out.println(test.coinChange_best_answer(coins, amount));
	}
	
	public int coinChange_best_answer(int[] coins,int amount){
		int f[] = new int[amount+1];
		for(int j=0;j<=amount;j++)
			f[j]= j%coins[0]==0? j/coins[0] : -1;
		for(int i=1;i<coins.length;i++){
			for(int j=1;j<=amount;j++){
				if(coins[i]<=j && f[j-coins[i]]!=-1)
					f[j]=Math.min(f[j]!=-1 ? f[j] : Integer.MAX_VALUE, f[j-coins[i]]+1);
			}
		}
		return f[amount];
	}
	
	public int coinChange_not_best_answer(int[] coins,int amount){
		int d[][] = new int[coins.length][amount+1];
		for(int j=0;j<=amount;j++)
			d[0][j] = j % coins[0] == 0 ? j/coins[0] : -1;
		for(int i=1,j=0;i<coins.length;i++){
			for(j=0;j<coins[i] && j<=amount;j++)
				d[i][j]=d[i-1][j];
			for(;j<=amount;j++){
				if((d[i][j-coins[i]]!=-1 && d[i-1][j]!=-1) ||(d[i][j-coins[i]]==-1 && d[i-1][j]==-1))
					d[i][j]=Math.min(d[i-1][j],d[i][j-coins[i]]+1);
				else if(d[i-1][j]==-1) 
					d[i][j]=d[i][j-coins[i]]+1;
				else 
					d[i][j]=d[i-1][j];
			}
		}
		return d[coins.length-1][amount];
	}
	// TLE 算法复杂度太高。
	public int coinChange(int[] coins, int amount) {
		if(amount==0) return 0;
		Arrays.sort(coins);
		return generate_2(coins,amount,coins.length-1);
    }
	
	//wrong solution! 并不是面额越大的硬币越多越好。
	public int generate_1(int[] coins,int amount,int k){
		if(amount==0) return 0;
		if(k==0){
			if(amount%coins[k]!=0) return -1;
			else return amount/coins[k];
		}else{
			int count = amount / coins[k];
			int temp=-1;
			for(int i=count;i>=0;i--)
				if((temp=generate_1(coins,amount-i*coins[k],k-1))!=-1) 
					return temp+i;
			return -1;
		}
	}
	
	
	public int generate_2(int[] coins,int amount,int k){
		if(k==0){
			if(amount%coins[k]!=0) return -1;
			else return amount/coins[k];
		}else{
			int count = amount / coins[k];
			int min = Integer.MAX_VALUE, temp=-1;
			for(int i=0;i<=count;i++)
				if((temp=generate_2(coins,amount-i*coins[k],k-1))!=-1) min=Math.min(temp+i, min);
			return min == Integer.MAX_VALUE ? -1 : min;
		}
	}
	
	//思路错误
	public int generate_wrong_answer(int[] coins,int amount,int k){
		if(amount==0) return 0;
		if(k==0){//已经剩下最后一个元素了
			if(amount<coins[k] || amount%coins[k]!=0) return -1;
			else return amount/coins[k];
		}else{//还有很多面额的硬币
			if(amount>=coins[k]){ //当前面额的硬币
				int t = generate_wrong_answer(coins,amount-coins[k]*(amount/coins[k]),k-1);
				int pickThis = t == -1 ? -1 : t + amount/coins[k];
				int notPickThis = generate_wrong_answer(coins,amount,k-1);
				int res = pickThis == -1 ? notPickThis : notPickThis == -1 ? pickThis : Math.min(pickThis, notPickThis);
				return res;
			}
			else{
				int res = generate_wrong_answer(coins,amount,k-1);
				return res;
			}
			
		}
	}
}
