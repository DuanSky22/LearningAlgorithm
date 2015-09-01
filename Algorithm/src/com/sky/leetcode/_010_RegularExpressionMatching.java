package com.sky.leetcode;
/*
 *  @author: DuanSky
 *    @time: 2015年8月19日 下午10:26:26
 * @content:

 */
public class _010_RegularExpressionMatching {
	public static void main(String args[]){
		System.out.println(isMatch("ab", ".*"));
	}
	public static boolean isMatch(String s,String p){
		if(s==null && p==null)
			return true;
		if((s!=null && p==null) || (s==null && p!=null ))
			return false;
		int n=s.length();
		int offset=0;
		for(int i=0;i<n;i++){
			char charS=s.charAt(i);
			//s没有匹配完，p匹配完
			if(offset>=p.length())
				return false;
			char charP=p.charAt(offset);
			if(charS==charP){//如果两个字符相等，直接往后匹配
				offset++;
				continue;
			}
			else{
				if(charP=='.'){
					offset++;
					continue;
				}
				else if(charP=='*'){
					if(offset<=0)
						return false;
					else{
						char before=p.charAt(offset-1);
						if(charS==before || before=='.'){
							offset++;
							continue;
						}
						else
							return false;
					}
				}
				else{
					if(offset+1==p.length())
						return false;
					else{
						char temp=p.charAt(offset+1);
						if(temp=='*'){
							offset+=2;
							if(offset>=p.length())
								return false;
							if(charS==p.charAt(offset)){
								offset++;
								continue;
							}
							else
								return false;
						}
					}
				}
			}
		}
		return true;
	}
}
