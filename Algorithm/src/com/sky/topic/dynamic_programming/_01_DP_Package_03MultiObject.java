package com.sky.topic.dynamic_programming;

/**
 * @author DuanSky
 * @date 2016年1月18日 下午6:35:27
 * @content <b>[多重背包问题]</b>&nbsp;&nbsp;
 *          有N种物品和一个容量为V的背包。第i种物品最多有n[i]件可用，每件体积是c[i]
 *          ，价值是w[i]。求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
 */

public class _01_DP_Package_03MultiObject {

	public static void main(String args[]) {
		_01_DP_Package_03MultiObject test = new _01_DP_Package_03MultiObject();
		int[] c = { 2, 2, 6, 1 };
		int[] w = { 6, 3, 5, 2 };
		int[] n = { 1, 3, 2, 2 };
		int v = 10;
		System.out.println(test.solution_2(c, w, n, v));
//		System.out.println(test.solution_1(c, w, n, v));
	}

	//转换成o(E(n))的01背包问题
	public  int solution_2(int[] c, int[] w, int[] n, int v) {
		int[] f = new int[v + 1];
		for (int i = 0; i < c.length; i++) {
			for (int j = v; j >= 0; j--) {
				for (int k = 0; k <= n[i]; k++) {
					if (k * c[i] <= j)
						f[j] = Math.max(f[j], f[j - k * c[i]] + k * w[i]);
				}
			}
		}
		return f[v];
	}
	
	

	public  int solution_wrong_answer(int[] c, int[] w, int[] n, int v) {
		int[] f = new int[v + 1];
		for(int j=1;j<=v;j++){
			for(int k=1;k<=n[0];k++){
				if(c[0]*k<=j) f[j]=k*w[0];
				else f[j]=f[j-1];
			}
		}
		for (int i = 1; i < c.length; i++) {
			for (int j = c[i]; j <= v; j++) {
				if (n[i]>0) {
					if(f[j-c[i]]+w[i]>f[j]){
						f[j]=f[j-c[i]]+w[i];
						if(f[j]>f[j-1])
							n[i]=n[i]-1;
					}
				}
			}
		}
		return f[v];
	}

}
