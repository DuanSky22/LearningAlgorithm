package com.sky.topic.string;
/**
 * @author DuanSky
 * @date 2016年4月11日 下午5:28:40
 * @content 
 * 低位优先的字符串排序（基数排序）
 */

public class LeastSignificantDigitFirst {
	
	public static void main(String args[]){
		for(int i = 0; i <= 256; i++)
			System.out.print((char)i+" ");
		String[] a = {
				"3405",
				"8927",
				"sb9e",
				"1001",
				"1011",
				"1001"
		};
		int W = 4;
		sort(a,W);
		System.out.println(a);
	}

	public static void sort(String[] a,int W){ //W 表示每个字符串的长度为W
		int R = 256; //字符串中不同字符数目
		int N = a.length; //字符串数目
		String[] aux = new String[N];
		for(int d = W - 1; d >= 0; d--){ //依据d位字符进行排序
			int[] counter = new int[R+1];  //统计频率
			for(int i = 0; i < N; i++)
				counter[a[i].charAt(d) + 1]++; //统计频率
			for(int i = 1; i <= R; i++)
				counter[i] += counter[i-1]; //计算偏移位置
			for(int i = 0; i < N; i++)
				aux[counter[a[i].charAt(d)]++] = a[i]; //将元素移动到指定位置
			for(int i = 0; i < N; i++) //回写
				a[i] = aux[i];
		}
		
	}
}
