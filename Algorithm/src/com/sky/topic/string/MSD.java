package com.sky.topic.string;
/**
 * @author DuanSky
 * @date 2016年4月11日 下午8:04:36
 * @content 
 * 高位优先的字符串排序
 */

public class MSD {
	
	public static void main(String args[]){
		String[] a = {
				"34051",
				"8927",
				"sb9e",
				"10011",
				"1011",
				"1001"
		};
		sort(a);
	}

	public static void sort(String[] s){
		sort(s,0,s.length,0);
	}
	
	//[begin,end)
	private static void sort(String[] s,int begin,int end, int bit){ //从begin开始 到end结束内字符串进行排序,依据bit位上的键值
		int R = 256;
		int[] counter = new int[R + 2];
		for(int i = begin; i < end; i++)
			counter[(bit >= s[i].length() ? -1 : s[i].charAt(bit)) + 2]++; //统计频率,注意  + 2 MISTAKE 
		for(int i = 1; i <= R+1; i++) 
			counter[i] += counter[i-1];  //计算起始位置
		String[] aux = new String[end - begin];
		for(int i = begin; i < end; i++)
			aux[counter[(bit >= s[i].length() ? -1 : s[i].charAt(bit)) + 1]++] = s[i]; //放置到正确的位置
		for(int i = begin; i < end; i++)
			s[i] = aux[i - begin];
		for(int i = 1; i <= R; i++){
			if(counter[i] != counter[i-1]){
				sort(s,begin,begin + counter[i] - counter[i-1],bit + 1);
				begin += counter[i] - counter[i-1];
			}
		}
		
		
	}
}
