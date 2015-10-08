/**
* @author DuanSky
* @date 2015年10月8日 下午8:39:40
* @content 
*/
package com.sky.leetcode;

public class RectangleArea_NotFinished {
	public static void main(String args[]){
		System.out.println(computeArea(-3,-3,3,-1,-2,-2,2,2));
	}
	//how to judge two line cross?
	public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int total=(C-A)*(D-B)+(G-E)*(H-F);
		if(E<=A && C<=G && F<=B && D<=H)
			return (G-E)*(H-F);
		else if(A<=E && G<=C && B<=F && H<=D)
			return (C-A)*(D-B);
		else if(((E<=A && A<G) || (E<C && C<=G)) && ((B<=F && F<D) || (B<H && H<=D))){
    	   int x_1=Math.max(A, E);
    	   int x_2=Math.min(G, C);
    	   
    	   int y_1=Math.max(B, F);
    	   int y_2=Math.min(D, H);
    	   
    	   return total-(y_2-y_1)*(x_2-x_1);
       }
        else
        	return total;
    }
}
