package com.sky.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author DuanSky
 * @date 2016年3月18日 下午4:27:52
 * @content 
 */

public class _310_Minimum_Height_Trees {
	public static void main(String args[]){
		_310_Minimum_Height_Trees test = new _310_Minimum_Height_Trees();
		int n = 4;
		int[][] edges = {{1,0},{1,2},{1,3}};
		test.findMinHeightTrees_1(n, edges);
	}
	//==============================================================================
	//利用节点的度的信息，从叶子节点开始剪枝
	public List<Integer> findMinHeightTrees_1(int n, int[][] edges) {
        List<Integer> leaves = new ArrayList<Integer>();
        if(n==1){//MISTAKE 注意特殊情况
        	leaves.add(0);
        	return leaves;
        }
        List<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++){
        	adj[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < edges.length; i ++){
        	int a = edges[i][0], b = edges[i][1];
        	adj[a].add(b); adj[b].add(a);
        }
        for(int i = 0; i < n; i++){
        	if(adj[i].size()==1) leaves.add(i);
        }
        while(n > 2){
        	int size = leaves.size();
        	for(int i = 0; i < size; i++){
        		Integer curr = leaves.remove(0); //当前的叶子节点
        		Integer next = adj[curr].get(0); //当前叶子节点相邻的节点
        		adj[next].remove(curr); //当前叶子节点相邻的节点删掉叶子节点
        		if(adj[next].size()==1)
        			leaves.add(next);
        	}
        	n -= size;
        }
        return leaves;
    }
	
	
	
	
	//==============================================================================
	//这样暴力搜索的代价太大！ Time Limit Exceeded 
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new LinkedList<Integer>();
        if(n==1){
        	res.add(0);
        	return res;
        }
        int[][] matrix = new int[n][n];
        for(int i = 0; i < edges.length; i++){
        	int from = edges[i][0];
        	int to = edges[i][1];
        	matrix[from][to]=1;
        	matrix[to][from]=1;
        }
        int min = n + 1;
        for(int i = 0; i < n; i++){
        	int curr = bfs(i,matrix);
        	if(curr < min){
        		min = curr;
        		res.clear();
        		res.add(i);
        	}
        	else if(curr == min)
        		res.add(i);
        }
        return res;
    }
	
	public int bfs(int source,int[][] matrix){
		int layer = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean hasVisited[] = new boolean[matrix.length];
		queue.add(source);
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i = 0; i < size; i++){
				int curr = queue.poll(); //当前节点
				hasVisited[curr] = true; //将当前节点设置成已经被访问
				for(int j = 0; j < matrix.length; j++){
					if(matrix[curr][j]==1 && !hasVisited[j]){
						queue.add(j);
					}
				}
			}
			layer++;
		}
		return layer;
	}
}
