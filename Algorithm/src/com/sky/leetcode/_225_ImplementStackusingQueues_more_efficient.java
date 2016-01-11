package com.sky.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author DuanSky
 * @date 2015年12月20日 下午12:44:07
 * @content
 * 	 
 */

public class _225_ImplementStackusingQueues_more_efficient {
	
	class MyStack {
		
		private Queue<Integer> data=new LinkedList<Integer>();
		
	    // Push element x onto stack.
	    public void push(int x) {
	    	if(data.isEmpty())
	    		data.add(x);
	    	else{
	    		Queue<Integer> temp=new LinkedList<Integer>();
	    		while(!data.isEmpty())
	    			temp.add(data.poll());
	    		data.add(x);
	    		while(!temp.isEmpty())
	    			data.add(temp.poll());
	    	}
	    }

	    // Removes the element on top of the stack.
	    public void pop() {
	        data.poll();
	    }

	    // Get the top element.
	    public int top() {
	    	return data.peek();
	    }

	    // Return whether the stack is empty.
	    public boolean empty() {
	        return data.isEmpty();
	    }
	}

}
