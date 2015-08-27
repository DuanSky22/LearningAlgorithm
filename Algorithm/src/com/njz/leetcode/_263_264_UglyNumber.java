package com.njz.leetcode;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.RequestingUserName;
import javax.swing.text.Position;

public class _263_264_UglyNumber {

	/**
	 * ����1 �жϷ�
	 */
	public static boolean isUgly(int num){
		if(num <= 0)
			return false;
		
		while(num % 5 == 0)
			num /= 5;
		while(num % 3 == 0)
			num /= 3;
		while(num % 2 == 0)
			num /= 2;
		
		if(num == 1)
			return true;
		return false;
	}
	
	/**
	 * @param n ���ɵ�n������
	 * ����2���õ���n���������������ɵķ��������ϳ���2��3��5�õ�����
	 */
	public static int ugly(int n){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		//����ָ���������?1��λ����
		int pos_ugly2 = 0;
		int pos_ugly3 = 0;
		int pos_ugly5 = 0;
		
		while(list.size() < n){
			int min_num = min(2*list.get(pos_ugly2), 3*list.get(pos_ugly3), 5*list.get(pos_ugly5));
			list.add(min_num);
			
			if(2*list.get(pos_ugly2) == min_num)
				pos_ugly2++;
			if(3*list.get(pos_ugly3) == min_num)
				pos_ugly3++;
			if(5*list.get(pos_ugly5) == min_num)
				pos_ugly5++;
		}
		return list.get(n-1);
	}
	
	public static int min(int a, int b, int c){
		int min = (a < b)? a : b;
		min = (min < c)? min : c;
		return min;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int test = 1;
		System.out.println("test1 : " + isUgly(test));
		System.out.println("test2 : " + ugly(test));
	}

}
