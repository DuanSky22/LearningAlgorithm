/**
 * Project Name:Algorithm
 * File Name:BitMap.java
 * Package Name:com.sky.topic.structure
 * Date:2016年5月20日下午5:07:23
 * Copyright (c) 2016, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.sky.topic.structure;

import java.util.Random;

/**
 * ClassName:BitMap <br/>
 * Date:     2016年5月20日 下午5:07:23 <br/>
 * @author   DuanSky
 * @version  
 * @see 	 
 */
public class BitMap {
	
	private int[] map;
	private int base = 0;
	
	/**
	 * Creates a new instance of BitMap whose number between min and max(inclusive).
	 *
	 */
	public BitMap(int min,int max){
		if(min >= max) throw new IllegalArgumentException("max must larger than min");
		int bit = max - min + 1;
		map = new int[bit/32+1];
		base = min;
	}
	
	public void buildMap(int[] numbers){
		if(numbers == null || numbers.length == 0) return;
		for(int i = 0; i < numbers.length; i++)
			buildMap0(numbers[i] - base);
	}

	private void buildMap0(int num) {
		int k = num >> 5; //分配到第k个整数。
		int bit = num & (0x1f); //分配到第bit位。
		map[k] = set(map[k],bit);
	}

	public boolean exists(int num){
		num -= base;
		int k = num >> 5;
		int bit = num & (0x1f);
		return ((map[k] >> bit) & 1) == 1;
	}
	
	public void order(int nums[]){
		buildMap(nums); int k = 0;
		for(int i = 0; i < map.length; i++){
			for(int bit = 0; bit < 32; bit++){
				if(test(map[i],bit))
					nums[k++]=getValue(i,bit)+base;
			}
		}
	}
	
	private int getValue(int k, int bit) {
		return 32 * k + bit;
	}

	/**
	 * set: set the bit position of the num to 1.<br/>
	 */
	public int set(int num, int bit) {
		return num |= 1<<bit;
	}
	/**
	 * clear: set the bit position of the num to 0.<br/>
	 */
	public int clear(int num, int bit){
		return num &= ~(1<<bit);
	}
	/**
	 * test: test if the bit position of the num is 1. <br/>
	 */
	public boolean test(int num,int bit){
		return (( num >> bit ) & 1) == 1;
	}
	
	public static void main(String args[]){
		int min = -1000;
		int max = 1000;
		
		Random random = new Random();
		int nums[] = {-1000,-999,99,1,34,98,-10};
//		for(int i = 0; i < nums.length; i++)
//			nums[i] = random.nextInt(max - min) + min;
		
		BitMap bitmap = new BitMap(min,max);
//		bitmap.buildMap(nums);
		bitmap.order(nums);
		for(int i = 0; i < nums.length; i++)
			System.out.println(nums[i]);
	}
	

}
