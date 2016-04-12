package com.sky.topic.string;
/**
 * @author DuanSky
 * @date 2016年4月11日 下午4:52:25
 * @content 
 * 	键索引计数法 p455
 */

public class KeyIndexCounter {
	
	public void sort(Data[] data,int r){
		if(data == null || data.length == 0) return;
		int n = data.length;
		int[] count = new int[r+1]; //对每种类型进行计数
		for(Data single : data)
			count[single.getKey() + 1]++;
		for(int i = 1; i <= r; i++)
			count[i] = count[i - 1] + count[i]; //计算每种类型的起始位置
		Data[] temp = new Data[n];
		for(Data single : data)
			temp[count[single.getKey()]++] = single; //将元素复制到对应位置上
		for(int i = 0; i < n; i++)
			data[i] = temp[i]; //回写
		
	}

}
