package com.sky.leetcode.first;

import java.util.ArrayDeque;
import java.util.Deque;

public class _239_Sliding_Window_Maximum {
	
	public static void main(String args[]){
		_239_Sliding_Window_Maximum test = new _239_Sliding_Window_Maximum();
		int[] a = {2,1,3,4,6,3,8,9,10,12,56};
		int k = 3;
		System.out.println(test.maxSlidingWindow(a, k));
		System.out.println(slidingWindowMax(a, k));
	}
	
	//下面的方法为啥可行？
	 public static int[] slidingWindowMax(final int[] in, final int w) {
		    final int[] max_left = new int[in.length];
		    final int[] max_right = new int[in.length];

		    max_left[0] = in[0];
		    max_right[in.length - 1] = in[in.length - 1];

		    for (int i = 1; i < in.length; i++) {
		        max_left[i] = (i % w == 0) ? in[i] : Math.max(max_left[i - 1], in[i]);

		        final int j = in.length - i - 1;
		        max_right[j] = (j % w == 0) ? in[j] : Math.max(max_right[j + 1], in[j]);
		    }

		    final int[] sliding_max = new int[in.length - w + 1];
		    for (int i = 0, j = 0; i + w <= in.length; i++) {
		        sliding_max[j++] = Math.max(max_right[i], max_left[i + w - 1]);
		    }

		    return sliding_max;
		}
	
	/*
	 * 队列里保留的是至多K个候选集。队列头部是当前[i-k+1,i]区间内的最大值。
	 * 当遇到下一个元素时，
	 * （1）先判断队列中的元素是否在[i-k+1,i]区间内，如果不在则移除队列中元素；
	 * （2）判断队列中的元素是否比当前元素大，如果不是，则移除队列中的该元素；
	 * （3）将该元素加入到队列中；
	 * （4）将队列顶部元素打印出来。
	 */
	public int[] maxSlidingWindow(int[] a, int k) {     
        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();//最先加入的元素放在了队列的头部，最后加入的元素放在了队列的尾部
        									// peek 打印队列的头部元素 
        									// poll 弹出队列的头部元素
        									// peekLast 打印队列的尾部元素
        									// pollLast 弹出队列的尾部元素
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k 首先必须保证队列中的所有元素都在k值范围内
            if (!q.isEmpty() && q.peek() < i - k + 1) {//判断最开始加入队列中的元素 是否还在[i-k+1,i]的范围内,如果不在，需要删除最开始入队的元素
            											 //其实就是判断队列中的元素是否失效
                q.poll();
            }
            // remove smaller numbers in k range as they are useless 其次需要保证队列内部的元素要比当前元素大
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) { //判断最近加入队列的元素是否比当前数组元素小，如果比当前数组元素小，则队列中该元素会被删掉
            												//其实就是判断队列中的元素是否是候选集
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i); //将当前元素加入到队列中
            if (i >= k - 1) { //必须遍历完前 k 个元素 才能开始打印输出
                r[ri++] = a[q.peek()];//当前的最大值都保存在队列头部
            }
        }
        return r;
    }

}
