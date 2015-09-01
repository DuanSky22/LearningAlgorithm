package com.sky.learningJava.chapter06;

public class SearchAlgorithm {
	
	
	public static void main(String args[]){
		int[] keys={1,3,4,5,6,7,8};
		SearchAlgorithm s=new SearchAlgorithm(keys);
		System.out.println(s.linearSearch(1));
		
		System.out.println(s.binarySearch(9));
	}
	
	private int[] keys; //关键字集合
	
	private int key; //要查找的关键字
	
	
	SearchAlgorithm(int[] keys){
		this.keys=keys;
	}
	
	SearchAlgorithm(int[] keys, int key){
		this.keys=keys;
		this.key=key;
	}
	
	public int linearSearch(int key){
		for(int i=0;i<keys.length;i++){
			if(key==keys[i])
				return i;
		}
		return -1;
	}
	
	public int binarySearch(int key){
		if(!testIsOrdered())
			throw new IllegalArgumentException("原始数据集合不是有序的，不能使用二分查找！");
		int bottom=0;
		int high=keys.length-1;
		
		while(bottom<=high){
			int middle=(bottom+high)/2;
			if(keys[middle]==key)
				return middle;
			else if(key<keys[middle])
				high=middle-1;
			else
				bottom=middle+1;
		}
		return -1;
	}
	
	public boolean testIsOrdered(){
		for(int i=0;i<keys.length-1;i++){
			if(keys[i]>keys[i+1])
				return false;
		}
		return true;
	}

}
