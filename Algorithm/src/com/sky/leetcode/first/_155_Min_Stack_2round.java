package com.sky.leetcode.first;

import java.util.Stack;

public class _155_Min_Stack_2round {
	
	class MinStack {
		
		Stack<Integer> container = new Stack<Integer>();
		Stack<Integer> min = new Stack<Integer>();
		
	    public void push(int x) {
	    	if(container.isEmpty()) min.add(x);
	    	else if(x <= min.peek()) min.add(x);
    		container.add(x);
	    }

	    public void pop() {
	        if(!container.isEmpty()){
	        	if(min.peek()==container.pop()) min.pop();
	        }
	    }

	    public int top() {
	        return container.peek();
	    }

	    public int getMin() {
	        return min.peek();
	    }
	}
}
