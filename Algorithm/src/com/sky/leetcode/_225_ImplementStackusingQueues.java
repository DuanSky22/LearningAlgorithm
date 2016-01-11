package com.sky.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author DuanSky
 * @date 2015年12月20日 下午12:44:07
 * @content
 * 	还是采用两个队列倒来倒去。 
 */

public class _225_ImplementStackusingQueues {
	
	class MyStack {
		
		private Queue<Integer> left=new LinkedList<Integer>();
		private Queue<Integer> right=new LinkedList<Integer>();
		
	    // Push element x onto stack.
	    public void push(int x) {
	        left.add(x);
	    }

	    // Removes the element on top of the stack.
	    public void pop() {
	        if(left.size()==1)
	        	left.poll();
	        else{
	        	while(left.size()!=1){
	        		right.add(left.poll());
	        	}
	        	left.poll();
	        	while(!right.isEmpty())
	        		left.add(right.poll());
	        }
	    }

	    // Get the top element.
	    public int top() {
	    	while(left.size()!=1){
        		right.add(left.poll());
        	}
        	int result=left.peek();
        	right.add(left.poll());
        	while(!right.isEmpty())
        		left.add(right.poll());
        	return result;
	    }

	    // Return whether the stack is empty.
	    public boolean empty() {
	        return left.isEmpty();
	    }
	}

}
