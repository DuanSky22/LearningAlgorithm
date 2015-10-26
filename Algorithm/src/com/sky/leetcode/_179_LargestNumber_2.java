/**
* @author DuanSky
* @date 2015年10月25日 下午3:45:14
* @content 
* Not familiar with selection sort :(
*/
package com.sky.leetcode;

import java.util.Arrays;

public class _179_LargestNumber_2 {
	
	public static void main(String args[]){
		//stringSortTest();
//		String sa="78987";
//		String sb="78987";
//		System.out.println(compare(sa,sb)+":"+compare0(sa,sb));
		
		int[] nums={1,0,0};
		System.out.println(largestNumber(nums));
	}
	
	public static String largestNumber(int[] nums) {
        if(nums.length==0)
        	return "";
        for(int i=0;i<nums.length-1;i++){
        	int max=nums[i];
        	int position=i;
        	for(int j=i;j<nums.length;j++){
        		if(compare(Integer.toString(nums[j]),Integer.toString(max))>0){
        			position=j;
        			max=nums[j];
        		}
        	}
        	/*
        	 * Pay attention! this method to switch two elements may get wrong answer
        	 * when the two elements are one element situation.
        	 */
//        	nums[i]=nums[i]^nums[position];
//        	nums[position]=nums[i]^nums[position];
//        	nums[i]=nums[i]^nums[position];
        	int temp=nums[i];
        	nums[i]=nums[position];
        	nums[position]=temp;
        }
        String result="";
        for(int i=0;i<nums.length;i++){
        	result+=nums[i];
        }
        while(result !=null && result!="" && result.charAt(0)=='0' && result.length()>1)
        	result=result.substring(1);
        
        return result;
    }
	
	public static int compare0(String a,String b){
		return (a+b).compareTo(b+a);
	}
	
	public static int compare(String sa,String sb){
		int minSize=Math.min(sa.length(), sb.length());
		int i=0;
		for(;i<minSize;i++){
			if(sa.charAt(i)<sb.charAt(i))
				return -1;
			else if(sa.charAt(i)>sb.charAt(i))
				return 1;
		}
		if(sa.length()==sb.length())
			return 0;
		else if(sa.length()<sb.length()){
			return compare(sa,sb.substring(i));
		}
		else{
			return compare(sa.substring(i),sb);
		}
	}
	
	public static void stringSortTest(){
		String[] list={"7","77","78","769","798"};
		Arrays.sort(list);
		System.out.print(list);
	}

}
