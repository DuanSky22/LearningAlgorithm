package com.sky.leetcode.first;
/**
 * @author DuanSky
 * @date 2016年1月8日 上午10:39:20
 * @content 
 */

public class _121_Best_Time_to_Buy_and_Sell_Stock {
	public static void main(String args[]){
		int[] prices=new int[]{3,1};
		System.out.println(maxProfit_3(prices));
	}
	
	public static int maxProfit_best_solution(int[] prices){
		if(prices.length<2) return 0;
		int min=prices[0],maxProfit=0;
		for(int i=1;i<prices.length;i++){
			//TRICK 中間的判断过程都可以不使用
//			if(prices[i]<min) min=prices[i];
//			else maxProfit=Math.max(maxProfit, prices[i]-min);
			min=Math.min(prices[i], min);
			maxProfit=Math.max(maxProfit, prices[i]-min);
		}
		return maxProfit;
	}
	
	public static int maxProfit_3(int[] prices){
		if(prices.length<2) return 0;
		int min=prices[0], max=prices[1], profit=0;
		for(int i=1;i<prices.length;i++){
			if(prices[i]<min){//如果比最小值还小
				profit = Math.max(profit, max-min);
				min=prices[i];
				max=-1;
				continue;
			}
			if(prices[i]>max){
				max=prices[i];
			}
			
		}
		profit = Math.max(profit,max-min);
		return profit<0 ? 0 : profit;
	}
	
	public static int maxProfit_2(int[] prices){
		int pos = findMaxPos(prices);
		if(pos<1) return 0;
		int sum=0;
		for(int i=0;i<pos;i++)
			sum+=prices[i];
		return pos*prices[pos]-sum;
	}
	
	public static int findMaxPos(int[] array){
		int max = Integer.MIN_VALUE,pos=-1;
		for(int i=0;i<array.length;i++){
			if(array[i]>max){
				max=array[i];
				pos=i;
			}
		}
		return pos;
	}
	
	public static int maxProfit_1(int[] prices){
        if(prices.length == 0) return 0;
        if(prices.length == 1) return prices[0];
        int curr=0,max = curr;
        for(int i=2;i<=prices.length;i++){
        	curr += (i-1) * (prices[i-1]-prices[i-2]);
        	max = Math.max(max, curr);
        }
        return max;
	}
	//下面这种算法是直接求解，没有利用之前的解信息，复杂度为o(n^2)
	public static int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        if(prices.length == 1) return prices[0];
        int max = 0;
        for(int i=2;i<=prices.length;i++){
        	int curr = (i-1) * prices[i-1];
        	for(int j=1;j<i;j++)
        		curr-=prices[j-1];
        	max = Math.max(curr, max);
        }
        return max;
    }
}
