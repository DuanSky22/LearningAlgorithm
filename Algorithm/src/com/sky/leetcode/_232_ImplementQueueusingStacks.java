package com.sky.leetcode;

import java.util.Stack;

/**
 * @author DuanSky
 * @date 2015年12月18日 下午1:12:34
 * @content 
 * 	采用两个栈，转过来转过去效率比较低，可以优化为只有在需要的时候才转。
 */

public class _232_ImplementQueueusingStacks {
	
	class MyQueue {
		
		Stack<Integer> left=new Stack<Integer>();
		Stack<Integer> right=new Stack<Integer>();
		
	    // Push element x to the back of queue.
	    public void push(int x) {
	        left.push(x);
	    }

	    // Removes the element from in front of queue.
	    public void pop() {
	    	if(!left.isEmpty()){
	    		while(!left.isEmpty()){//left -> right 
	    			right.add(left.pop());
	    		}
	    		right.pop();
	    		while(!right.isEmpty()){//right -> left
	    			left.add(right.pop());
	    		}
	    	}
	    }

	    // Get the front element.
	    public int peek() {
	        while(!left.isEmpty()){
	        	right.add(left.pop());
	        }
	        int result=right.peek();
	        while(!right.isEmpty()){
	        	left.add(right.pop());
	        }
	        return result;
	    }

	    // Return whether the queue is empty.
	    public boolean empty() {
	        return left.isEmpty();
	    }
	}

}
