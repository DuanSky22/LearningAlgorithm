package com.sky.topic.string;

public class Quick3 {
	
	public static void main(String args[]){
		String[] a = {
				"3405",
				"8927",
				"sb9e",
				"1001",
				"1011",
				"1001"
		};
		sort(a);
	}
	
	public static void sort(String[] a){
		sort(a,0,a.length,0);
	}
	
	private static int charAt(String s, int bit){
		return (s != null && s.length() > bit) ? s.charAt(bit) : -1;
	}
	private static void swap(String[] a,int m,int n){
		String t = a[m];
		a[m] = a[n];
		a[n] = t;
	}
	//对字符串[begin,end)区间内的字符串以第bit位上的字符为键进行排序
	private static void sort(String[] a, int begin, int end, int bit){
		if(end <= begin + 1) return;
		int low = begin, high = end - 1; //low指向<key值位置，high指向>key值位置
		int key = charAt(a[begin],bit);
		int i = low;
		while(i <= high){//三路快排
			int t = charAt(a[i],bit);
			if(t < key) 
				swap(a,i++,low++);
			else if(t > key) 
				swap(a,i,high--);
			else 
				i++;
		}
		sort(a,begin,low,bit);
		if(key >= 0) sort(a,low,high+1,bit+1); //MISTAKE 特别需要注意，这里需要判断key值
		sort(a,high+1,end,bit);
	}

}
