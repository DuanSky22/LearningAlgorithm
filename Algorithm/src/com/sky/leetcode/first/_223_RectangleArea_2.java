/**
* @author DuanSky
* @date 2015��10��8�� ����8:39:40
* @content 
*/
package com.sky.leetcode.first;

public class _223_RectangleArea_2 {
	public static void main(String args[]){
		System.out.println(computeArea(-3,-3,3,-1,-2,-2,2,2));
	}
	//how to judge two line cross?
	public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		if(A<=E && G<=C && B<=F && H<=D)
			return (C-A)*(D-B);
		else if(E<=A && C<=G && F<=B && D<=H)
			return (G-E)*(H-F);
		else{
			int x_1=Math.max(E, A);
			int x_2=Math.min(G, C);
			int y_1=Math.max(B, F);
			int y_2=Math.min(D, H);
			if(x_1<x_2 && y_1<y_2)
				return (C-A)*(D-B)+(G-E)*(H-F)-(x_2-x_1)*(y_2-y_1);
			else 
				return (C-A)*(D-B)+(G-E)*(H-F);
		}
    }
}
