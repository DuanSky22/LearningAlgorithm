package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2016年1月8日 下午12:42:25
 * @content 
 */

public class _122_Best_Time_to_Buy_and_Sell_Stock_II {
	
	public static void main(String args[]){
		int[] prices = new int[]{5,2,3,2,6,6,2,9,1,0,7,4,5,0};
		System.out.println(maxProfit(prices));
	}
	
	//TRICK Its amazing!
	public static int maxProfit_trick(int[] prices){
		int total = 0;
		for(int i=0;i<prices.length-1;i++)
			if(prices[i]<prices[i+1])
				total+=prices[i+1]-prices[i];
		return total;
	}
	/*
	 * 该题的思想即为将价格表分成若干个由波峰分割的段，在每一个波峰内，波谷时买入，波峰是卖出。
	 * 再将每个波峰的收入累加即为总利益。
	 * 然后推出两个问题：
	 * （1）如何找到波峰？
	 * （2）如何计算波峰的收益？
	 */
	public static int maxProfit(int[] prices) {
		if(prices.length<=1) return 0;
		int profit = 0, curMin=prices[0];
		for(int i=1;i<prices.length;i++){
			if(prices[i]<curMin){//如果当前的值比最小值还小，即为波谷
				curMin = prices[i];
				continue;
			}
			//MISTAKE 如果遇到重复的数据该怎么办？这样判断波峰的方法有问题。
			int counter=1;
			while(i<prices.length-1 && prices[i]==prices[i+1]) {counter++; i++; }
			if(prices[i]>prices[i-counter] && (i==prices.length-1 || prices[i]>prices[i+1])){//遇到了波峰
				profit += prices[i]-curMin;
				curMin = i==prices.length-1 ? 0 : prices[i+1]; //更新波谷
				i++;
			}
		}
		return profit;
    }
}
