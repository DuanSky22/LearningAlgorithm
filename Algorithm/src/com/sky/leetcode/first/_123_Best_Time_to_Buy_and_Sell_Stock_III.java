package com.sky.leetcode.first;
/**
 * @author DuanSky
 * @date 2016年1月19日 上午9:58:27
 * @content 
 */

public class _123_Best_Time_to_Buy_and_Sell_Stock_III {
	
	public static int maxProfit(int[] prices){
		if(prices.length<2) return 0;
		int f[]=new int[prices.length]; //f[i]表示从第0天到第i天中，选择两天交易所能够获取的最大利润；
		int g[]=new int[prices.length]; //g[i]表示从第i天到最后一天中，选择两天交易所能够获取的最大利润。
		int min=prices[0], max=prices[prices.length-1],maxProfit=0;
		
		for(int i=1;i<f.length;i++){
			min = Math.min(min, prices[i]);
			f[i] = Math.max(f[i-1], prices[i]-min);
		}
		
		for(int j=g.length-2;j>=0;j--){
			max = Math.max(max, prices[j]);
			g[j]=Math.max(g[j+1], max-prices[j]);
		}
		
		for(int k=0;k<f.length;k++)
			maxProfit = Math.max(f[k]+g[k], maxProfit);
		
		return maxProfit;
	}

}
