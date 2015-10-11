/**
* @author DuanSky
* @date 2015年10月11日 下午1:49:03
* @content 
*/
package com.sky.leetcode;

import java.util.HashSet;
import java.util.Set;

public class SingleNumberIII {
	
	public static void main(String args[]){
		int[] nums={1,1,2,2,3,3,4,5};
		System.out.println(singleNumber0(nums));

		System.out.println(singleNumber(nums));
	}
	
	/*
	 * here is the elegant solution!
	 * If we XOR all the element, we will get x XOR y in which 
	 * x and y is our target.
	 * So how to find x and y ?
	 * We know that x and y is distinct, so x XOR y must not equals zero.
	 * So there must exists one bit that equals one.
	 * We find the first bit from right order that x and y is difference,
	 * this will be key to distinguish x and y.
	 */
	public static int[] singleNumber(int[] nums) {
        int[] result={0,0};
        int xor=0;
        //first step,we get xor result.
        for(int i=0;i<nums.length;i++){
        	xor^=nums[i];
        }
        //second step, we find the first bit that x and y is not equals.
        xor&=-xor;
        //third step, we distinguish x and y by this bit.
        for(int i=0;i<nums.length;i++){
        	if((nums[i]&xor)==0){
        		result[0]^=nums[i];
        	}
        	else
        		result[1]^=nums[i];
        }
        return result;
    }
	
	//here we use set struts, it's linear runtime but costs linear space.
	public static int[] singleNumber0(int[] nums) {
        int[] result={0,0};
        Set<Integer> set=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
        	if(set.contains(nums[i]))
        		set.remove(nums[i]);
        	else
        		set.add(nums[i]);
        }
        int t=0;
        for(Object o : set.toArray()){
        	result[t++]=(int)o;
        }
        return result;
    }
}
