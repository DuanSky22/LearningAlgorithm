package com.sky.leetcode;
/*
 *  @author: DuanSky
 *    @time: 2015��8��19�� ����10:26:26
 * @content:

 */
public class _010_RegularExpressionMatching_NotFinished {
	public static void main(String args[]){
		System.out.println(isMatch("aa", "a"));
	}
	
	public static boolean isMatch(String s,String p){
		boolean result=false;
		return result;
	}
	
	public static boolean isMatch_wrong_solution(String s,String p){
		if(s==null && p==null)
			return true;
		if((s!=null && p==null) || (s==null && p!=null ))
			return false;
		int n=s.length();
		int offset=0;
		for(int i=0;i<n;i++){
			char charS=s.charAt(i);
			//sû��ƥ���꣬pƥ����
			if(offset>=p.length())
				return false;
			char charP=p.charAt(offset);
			if(charS==charP){//��������ַ���ȣ�ֱ������ƥ��
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
