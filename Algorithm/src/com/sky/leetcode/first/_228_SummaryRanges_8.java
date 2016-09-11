/**
* @author DuanSky
* @date 2015��10��10�� ����7:31:09
* @content 
*/
package com.sky.leetcode.first;

import java.util.ArrayList;
import java.util.List;

public class _228_SummaryRanges_8 {
	public static void main(String args[]){
		String s="-111111";
		int t=Integer.parseInt(s);
		int[] nums={0,8,9};
		System.out.println(summaryRanges(nums));
	}
	public static List<String> summaryRanges(int[] nums) {
        List<String> result=new ArrayList<String>();
        if(nums.length==0)
            return result;
        int current=0;
        int i=1;
        for(i=1;i<nums.length;i++){
        	/*
        	 * First time the follow line I write like this 
        	 * nums[i]!=nums[current]+i
        	 * while the right answer is like this
        	 * nums[i]!=nums[current]+i-current
        	 * Think carefully!
        	 * I even forget to compare current and i for the sake of 
        	 * single value like "9->9"!
        	 */
        	
            if(nums[i]!=nums[current]+i-current){
                result.add( current+1==i ? nums[current]+"" : nums[current]+"->"+nums[i-1]);
                current=i;
            }
        }
        if(current+1==i)
            result.add(nums[current]+"");
        else
            result.add(nums[current]+"->"+nums[i-1]);
        return result;
    }	
}
