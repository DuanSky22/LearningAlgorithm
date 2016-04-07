package com.sky.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author DuanSky
 * @date 2016年3月17日 下午2:34:27
 * @content 
 * 
 */

public class _207_Course_Schedule {
	
	public static void main(String args[]){
		int numCourses = 2;
		int[][] prerequisites = {{1,0}};
		_207_Course_Schedule test = new _207_Course_Schedule();
		System.out.println(test.canFinish_2(numCourses, prerequisites));
	}

	public boolean canFinish_3(int numCourses,int[][] prerequisites){
		int[][] matrix = new int[numCourses][numCourses];
		int[] indegree = new int[numCourses];
		for(int i = 0; i < prerequisites.length; i++){ //初始化建立邻接矩阵 和 节点入度
			int from = prerequisites[i][0];
			int to = prerequisites[i][1];
			if(matrix[from][to]==0)
				indegree[to]++;//MISTAKE 过滤掉出现重复的情况
			matrix[from][to]=1;
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i = 0; i < numCourses; i++){
			if(indegree[i]==0) queue.add(i);
		}
		int counter = 0;
		while(!queue.isEmpty()){
			counter ++;
			int source = queue.poll();
			for(int i = 0; i < numCourses; i++){
				if(matrix[source][i]==1){
					if(--indegree[i]==0) queue.add(i);
				}
			}
		}
		return counter == numCourses;
		
	}
	
	//不断地拿走节点和该节点相邻的边，重复这个过程，直到所有的节点都被拿走。当存在环时，会使得有些节点拿不走
	public boolean canFinish(int numCourses, int[][] prerequisites) {
	    int[][] matrix = new int[numCourses][numCourses]; // 采用邻接矩阵来存储
	    int[] indegree = new int[numCourses];

	    for (int i=0; i<prerequisites.length; i++) {
	        int ready = prerequisites[i][0];
	        int pre = prerequisites[i][1];
	        if (matrix[pre][ready] == 0)
	            indegree[ready]++; //过滤掉重复的元素
	        matrix[pre][ready] = 1;
	    }

	    int count = 0;
	    Queue<Integer> queue = new LinkedList();
	    for (int i=0; i<indegree.length; i++) {
	        if (indegree[i] == 0) queue.offer(i); //找出节点入度为0的节点，如果节点入度为0，表示该节点是起始节点
	    }
	    while (!queue.isEmpty()) {
	        int course = queue.poll(); //先拿出一个起始节点
	        count++;
	        for (int i=0; i<numCourses; i++) {
	            if (matrix[course][i] == 1) { //对于起始节点相邻的节点
	                if (--indegree[i] == 0) 
	                    queue.offer(i);
	            }
	        }
	    }
	    return count == numCourses;
	}
	
	//==========================================================================
	//32ms 36.79%
	public boolean canFinish_2(int numCourses,int[][] prerequisites){
		int[] visited = new int[numCourses];
		int[][] matrix = new int[numCourses][numCourses]; //将边集转换成邻接矩阵
		for(int i = 0; i < prerequisites.length; i++)
			matrix[prerequisites[i][0]][prerequisites[i][1]]=1;
		for(int i = 0; i < numCourses; i++){
			if(visited[i]==0 && DFS(i,visited,matrix)==false) return false;
		}
		return true;
	}
	public boolean DFS(int current,int[] visited,int[][] matrix){
		visited[current] = 1; //将当前的节点置为灰色，表示正在访问
		boolean res = true;
		for(int i = 0; i < matrix.length; i++){
			if(matrix[current][i]==1){
				if(visited[i]==1) return false; //如果邻接点也是灰色，则是反向边
				if(visited[i]==0) res = DFS(i,visited,matrix);
			}
		}
		visited[current]=2;
		return res;
	}
	
	
	//==========================================================================
	public void BFS(int numCourses,int[][] prerequisites){
		int[] visited = new int[numCourses];
		int[][] adj = new int[numCourses][numCourses]; //将边集转换成邻接矩阵
		for(int i = 0; i < prerequisites.length; i++)
			adj[prerequisites[i][0]][prerequisites[i][1]]=1;
		for(int source = 0; source < numCourses; source++){
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(source);
			while(!queue.isEmpty()){
				Integer curr = queue.poll();
				for(int i = 0; i < numCourses; i++){
					if(adj[curr][i]==1 && visited[i]==0){//如果邻接点没有被访问
						visited[i]=1; //邻接点正在被访问
						queue.add(i);
					}
				}
				visited[curr]=2; //当前节点已经被访问
			}
		}
	}
	
	//==========================================================================
	//深度优先遍历，检测某个节点开始，是否会以该节点结束，即该节点会有收尾连接情况 Time Limited
	public boolean canFinish_1(int numCourses, int[][] prerequisites) {
       Set<Integer> hasVisited = new HashSet<Integer>();
       for(int i = 0; i < numCourses; i++){
    	   if(hasVisited.contains(i)) continue; //如果已经加入到树中，则跳过当前的节点
    	   if(hasVisited.size() == numCourses) return true;
    	   ScheduleTree root = new ScheduleTree(0), temp = root;
    	   root.addCourse(i); 
    	   
    	   while(temp.getCourseNumber()!=0){
    		   ScheduleTree next = new ScheduleTree(temp.getLayer()+1); //现在建立下一层的元素
    		   Set<Integer> currLayerCourses = temp.getCourses(); //获取该层的所有课程
    		   for(int currCourse : currLayerCourses){ 
    			   List<Integer> postCourses = getPostCourses(currCourse,prerequisites); //针对该层的任何一个课程，找出它的所有的前置课程
    			   for(int postCourse : postCourses){
        			   if(root.existsBeforeLayer(next.getLayer()-2, postCourse)) 
        				   return false;
    	    		   hasVisited.add(postCourse); //访问这个节点
    	    		   next.addCourse(postCourse); 
    	    	   }
    		   }
    		   temp.next = next;
    		   temp = next;
    	   } 
       }
       return true;
    }
	
	public List<Integer> getPostCourses(int course,int[][] prerequisites){
		List<Integer> res = new LinkedList<Integer>();
		for(int i = 0; i < prerequisites.length; i++){
			if(prerequisites[i][0]==course)
				res.add(prerequisites[i][1]);
		}
		return res;
	}
	
	//数据结构复杂，操作超时
	class ScheduleTree{
		int layer = 0; //当前所在的层数
		Set<Integer> courses = new HashSet<Integer>(); //当前的课程集合
		int courseNumber = 0; //当前课程数目
		ScheduleTree next = null;
		
		public ScheduleTree(int layer){
			this.layer = layer;
		}
		
		public int getLayer(){
			return layer;
		}
		
		public void addCourse(int course){
			courses.add(course);
			courseNumber++;
		}
		
		public Set<Integer> getCourses(){
			return courses;
		}
		
		public int getCourseNumber(){
			return courseNumber;
		}
		
		//inclusive
		public boolean existsBeforeLayer(int layer,int target){
			ScheduleTree tree = this;
			if(layer == -1 || tree == null) return false;

			for(int i = 0; i <= layer && tree != null; i++){
				Set<Integer> currCourses = tree.getCourses();
				if(currCourses != null && currCourses.contains(target)) return true;
				tree = tree.next;
			}
			return false;
		}
	}
}
