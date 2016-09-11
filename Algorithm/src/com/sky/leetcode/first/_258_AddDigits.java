/**
* @author DuanSky
* @date 2015��9��28�� ����9:16:05
* @content 
*/
package com.sky.leetcode.first;

public class _258_AddDigits {

	public static void main(String args[]){
		for(int i=0;i<1000;i++){
			System.out.println((i-1)%9+1);
			System.out.println(addDigits(i));
		}
			
		
	}
	//here the o(1) algorithm is (n-1)%9+1.
	public static int addDigits(int num) {
		//don't forget the equal situation.
        while(num>=10){
        	int sum=0;
        	while(num/10!=0){
            	sum+=num%10;
            	num=num/10;
            }
            sum+=num;
            num=sum;
        }
        return num;
    }
}
