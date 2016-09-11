package com.sky.leetcode.first;

import java.util.Stack;

public class _155_Min_Stack_2round_2 {
	
	public static void main(String args[]){
		MinStack test = new MinStack();
		test.push(2); test.push(0); test.push(3); test.push(0);
		System.out.println(test.getMin());
		test.pop();
		System.out.println(test.getMin());
		test.pop();
		System.out.println(test.getMin());
		test.pop();
		System.out.println(test.getMin());
	}
	
static class MinStack {
		
		Stack<Long> container = new Stack<Long>();
        long min = Integer.MAX_VALUE; //min 栈中最小值
        
	    public void push(int x) {
            container.push(x-min);
        	if(x<min) min = x; //更新min 
	    }

	    public void pop() {
	        if(!container.isEmpty()){
	            long top = container.pop();
	            if(top < 0) min = min -top;
	        }
	    }

	    public int top() {
	        long top = container.peek();
	        if(top > 0) return (int)(top + min);
	        else return (int)min;
	    }

	    public int getMin() {
	        return (int)min;
	    }
	}
}
