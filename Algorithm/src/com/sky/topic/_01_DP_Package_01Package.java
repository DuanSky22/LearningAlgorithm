package com.sky.topic;
/**
 * @author DuanSky
 * @date 2016年1月15日 上午10:42:13
 * @content
 * <b>[01背包问题]</b>&nbsp;&nbsp;
 * 有N件物品和一个容量为V的背包。第i件物品的体积是c[i]，价值是w[i]。求解将哪些物品装入背包可使价值总和最大。 
 * <li>(1) 最大值是多少?
 * <li>(2) 所有取得最大值时的解的状态?
 * <li>(3) 如果要求背包恰好装满，是否存在该条件下的最大值？如果存在求出最大值，如果不存在，返回-1.
 */

public class _01_DP_Package_01Package {
	
	public static void main(String args[]){
		_01_DP_Package_01Package test = new _01_DP_Package_01Package();
		int[] c = {2,2,16,1};
		int[] w = {6,3,5,6};
		int v =10;
		System.out.println(test.zeroOnePackage(c, w, v));
		System.out.println(test.solution_2(c, w, v));
		System.out.println(test.solution_3(c, w, v));
	}
	
	public int zeroOnePackage(int[] c,int[] w,int v){
		return solution(c,w,v,c.length-1);
	}
	
	//时间复杂度为o(NV),空间复杂度为0.递归求解。
	public int solution(int[] c,int[] w,int v,int k){
		if(k<0) return 0;
		if(c[k]>v) return solution(c,w,v,k-1);
		else return Math.max(solution(c,w,v-c[k],k-1)+w[k],solution(c,w,v,k-1));
	}
	//非递归求解 空间复杂度为o(n^2),时间复杂度仍然为o(NV)
	public int solution_2(int[] c,int[] w,int v){
		int[][] res = new int[c.length+1][v+1];
		for(int i=1;i<=c.length;i++){//第i个物品 i从1开始
			for(int j=v;j>=0;j--){
				if(c[i-1]<=j) 
					res[i][j]=Math.max(res[i-1][j], res[i-1][j-c[i-1]]+w[i-1]);
				else 
					res[i][j]=res[i-1][j];
			}
		}
		return res[c.length][v];
	}
	//非递归求解 空间复杂度为o(n)，时间复杂度任然为o(NV)
	public int solution_3(int[] c,int[] w,int v){
		int[] res = new int[v+1];
		for(int i=0;i<c.length;i++){ //从第一个到最后一个
			for(int j=v;j>=0;j--){//MISTAKE 从最后一个到第一个，思考为什么
				if(c[i]<=j) 
					res[j]=Math.max(res[j-c[i]]+w[i], res[j]);
			}
		}
		return res[v];
	}

}
