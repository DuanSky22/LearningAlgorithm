package com.sky.topic;

/**
 * @author DuanSky
 * @date 2016年1月15日 下午5:27:08
 * @content  <b>[完全背包问题]</b>&nbsp;&nbsp;
 *          有N种物品和一个容量为V的背包，每种物品都有无限件可用。第i种物品的费用是c[i]，
 *          价值是w[i]。求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
 */

public class _01_DP_Package_02CompletePackage {

	public static void main(String args[]) {
		_01_DP_Package_02CompletePackage test = new _01_DP_Package_02CompletePackage();
		int[] c = { 2, 3, 6, 1, 1 };
		int[] w = { 6, 3, 5, 2, 4 };
		int v = 10;
		System.out.println(test.solution_1(c, w, v));
		System.out.println(test.solution_2(c, w, v));
	}

	public int solution_1(int[] c, int[] w, int v) {
		return solution_(c, w, v, c.length - 1);
	}

	private int solution_(int[] c, int[] w, int v, int k) {
		if (k < 0)
			return 0;
		else if (c[k] > v)
			return solution_(c, w, v, k - 1);
		else
			return Math.max(solution_(c, w, v, k - 1),
					solution_(c, w, v - c[k], k) + w[k]);
	}

	public int solution_2(int[] c, int[] w, int v) {
		int f[] = new int[v + 1];
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j <= v; j++) {
				if (c[i] <= j)
					f[j] = Math.max(f[j], f[j - c[i]] + w[i]);
			}
		}
		return f[v];
	}

}
