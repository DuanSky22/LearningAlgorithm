package com.sky.leetcode;
/**
 * @author DuanSky
 * @date 2016年3月25日 下午5:33:20
 * @content 
 */

public class _165_Compare_Version_Numbers {
	
	public static void main(String args[]){
		_165_Compare_Version_Numbers test = new _165_Compare_Version_Numbers();
		String version1 = "1.0";
		String version2 = "13.37";
		System.out.println(test.compareVersion(version1, version2));
		
	}
	
	public int compareVersion(String version1, String version2) {
        for(int i = 0, j = 0; i < version1.length() && j < version2.length();){
        	int m = version1.indexOf('.', i), n = version2.indexOf('.', j);
        	if(m == -1 && n == -1)//都遍历到了最后一个元素
        		return Integer.compare(Integer.parseInt(version1.substring(i)), Integer.parseInt(version2.substring(j)));
        	else if(m == -1 && n != -1) //version1遍历到末尾，version2还没有
        		return Integer.parseInt(version1.substring(i)) > Integer.parseInt(version2.substring(j,n)) ? 1 : -1;
        	else if(m != -1 && n == -1)
        		return Integer.parseInt(version2.substring(j)) > Integer.parseInt(version1.substring(i,m)) ? 1 : -1;
			int t1 = Integer.parseInt(version1.substring(i,m)), t2 = Integer.parseInt(version2.substring(j,n));
			if(t1 != t2)
				return t1 > t2 ? 1 : (t1 == t2 ? 0 : -1);
			i = m + 1; j = n + 1;
        }
        return 0;
    }
}
