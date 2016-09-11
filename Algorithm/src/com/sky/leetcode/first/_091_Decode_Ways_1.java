package com.sky.leetcode.first;
/**
 * @author DuanSky
 * @date 2016年1月11日 下午4:19:59
 * @content 
 * 	本题需要考虑特殊情况，即不能解码的情况！WTF.
 */

public class _091_Decode_Ways_1 {
	public static void main(String args[]){
		String s="02";
		System.out.println(numDecodings_(s));
		System.out.println(numDecodings(s));
	}
	
	public static int numDecodings_(String s){
		int size = s.length();
		if(size==0 || s.charAt(0)=='0') return 0;
		int d[] = new int[size+1];d[0]=1; d[1]=1; boolean flag=false;
		for(int i=2;i<=size;i++){
			if("0".equals(s.substring(i-1,i))){//本位置上为0,则该元素必须和前面一位结合。即，0不能单独组成一个字符
				if(flag || i==size) return 0;
				else{
					d[i]=d[i-2];
					flag = true;
				}
			}
			else if(!"0".equals(s.substring(i-2,i-1)) && Integer.parseInt(s.substring(i-2,i))<=26){
				d[i]=d[i-2]+d[i-1]; flag=false;
			}
			else{
				d[i]=d[i-1]; flag=false;
			}
		}
		return d[size];
	}
	
	//递归算法，动态规划  time limit exceeded !!! wrong answer!
	public static int numDecodings(String s) {
      if(s.length()<=1) return  s.length()==0 || "0".equals(s.substring(0,s.length())) ? 0 : 1;
      if(Integer.parseInt(s.substring(0,2))>26) return numDecodings(s.substring(1,s.length()));
      else if(Integer.parseInt(s.substring(0,1))==0) return numDecodings(s.substring(1,s.length()));
      else return numDecodings(s.substring(1,s.length()))+numDecodings(s.substring(2,s.length()));
    }
	

}
