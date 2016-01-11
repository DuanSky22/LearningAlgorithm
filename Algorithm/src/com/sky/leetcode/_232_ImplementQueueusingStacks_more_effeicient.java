package com.sky.leetcode;

import java.util.Stack;

/**
 * @author DuanSky
 * @date 2015年12月18日 下午1:12:34
 * @content 
 * 	采用两个栈，转过来转过去效率比较低，可以优化为只有在需要的时候才转。
 */

public class _232_ImplementQueueusingStacks_more_effeicient {
	
	class MyQueue {
		
		Stack<Integer> input=new Stack<Integer>();
		Stack<Integer> output=new Stack<Integer>();
		
	    // Push element x to the back of queue.
	    public void push(int x) {
	       input.push(x);
	    }

	    // Removes the element from in front of queue.
	    public void pop() {
	    	peek();
	    	output.pop();
	    }

	    // Get the front element.
	    public int peek() {
	    	if(output.isEmpty()){ //如果output为空，说明之前放进去的已经弹完了，可以将现在积攒的再重新压栈。
	    		while(!input.isEmpty()){
	    			output.push(input.pop());
	    		}
	    	}
	    	return output.peek();
	    }

	    // Return whether the queue is empty.
	    public boolean empty() {
	    	//MISTAKE 注意这里是 && 不是 ||。只有两个栈都为空的时候才为空。
	       return input.isEmpty() && output.isEmpty();
	    }
	}

}
